package za.ac.nwu.das.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.service.GeneralResponse;
import za.ac.nwu.das.logic.service.CreateAccountTransactionService;
import za.ac.nwu.das.logic.service.FetchAccountTransactionService;
//import za.ac.nwu.das.logic.service.implementation.CreateAccountTransactionServiceImp;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final FetchAccountTransactionService fetchAccountTransactionService;
    private final CreateAccountTransactionService createAccountTransactionService;

    //LOGGING
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountTransactionController.class);

    @Autowired
    public AccountTransactionController(FetchAccountTransactionService fetchAccountTransactionService,
                                        CreateAccountTransactionService createAccountTransactionService){
        this.fetchAccountTransactionService = fetchAccountTransactionService;
        this.createAccountTransactionService = createAccountTransactionService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all Account Transactions", notes = "Returns a list of account type.")
    @ApiResponses(value ={
                    @ApiResponse(code = 200, message = "Transactions Returned", response = GeneralResponse.class),
                    @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                    @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
                    @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){

        long startTime = System.nanoTime();
        LOGGER.debug("Get list of transactions from DB");

        List<AccountTransactionDto> transactions = fetchAccountTransactionService.getAllTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, transactions);
        ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> generalResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        LOGGER.info("Response time {}", (System.nanoTime() - startTime)/1000000L);

        return generalResponseEntity;
    }

    @GetMapping("/{transactionId}")
    @ApiOperation(value = "Fetches a specified Account Transaction.", notes = "Fetches an AccountTransaction corresponding to the transactionId input.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transactions Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value = "The transactionId that is used to uniquely identify an AccountTransaction.",
                        example = "10001",
                        name = "transactionId",
                        required = true)
            @PathVariable("transactionId") final Long transactionId){

        long startTime = System.nanoTime();
        LOGGER.debug("Get a specific transaction from DB");

        AccountTransactionDto accountTransaction = fetchAccountTransactionService.getTransactionById(transactionId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);
        ResponseEntity<GeneralResponse<AccountTransactionDto>> generalResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        LOGGER.info("Response time {}", (System.nanoTime() - startTime)/1000000L);

        return generalResponseEntity;
    }


    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountTransaction", notes= "Creates a new AccountTransaction in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created succesfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction.", required = true)
            @RequestBody AccountTransactionDto accountTransaction){

        long startTime = System.nanoTime();
        LOGGER.debug("Create a new AccountTransaction");

        AccountTransactionDto transactionResponse = createAccountTransactionService.createAccountTransaction(accountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, transactionResponse);
        ResponseEntity<GeneralResponse<AccountTransactionDto>> generalResponseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);

        LOGGER.info("Response time {}", (System.nanoTime() - startTime)/1000000L);

        return generalResponseEntity;
    }

    @GetMapping("/{mnemonic}")
    @ApiOperation(value = "Calculates total value of AccountTransactions for an AccountType of a member.", notes = "Calculates total value of an Account Type from all of a member's AccountTransactions.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transactions Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<Long>> getTotalValue(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable ("mnemonic") final String mnemonic){

        long startTime = System.nanoTime();
        LOGGER.debug("Calculates value of an AccountType through AccountTransactions made");

        Long accountValue = fetchAccountTransactionService.getTotalValueOfMnemonic(mnemonic);
        GeneralResponse<Long> response = new GeneralResponse<>(true, accountValue);
        ResponseEntity<GeneralResponse<Long>> generalResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        LOGGER.info("Response time {}", (System.nanoTime() - startTime)/1000000L);

        return generalResponseEntity;
    }


}
