package za.ac.nwu.das.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.service.GeneralResponse;
import za.ac.nwu.das.logic.service.CreateAccountTransactionService;
import za.ac.nwu.das.logic.service.FetchAccountTransactionService;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final FetchAccountTransactionService fetchAccountTransactionService;
    private final CreateAccountTransactionService createAccountTransactionService;


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

        List<AccountTransactionDto> transactions = fetchAccountTransactionService.getAllTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, transactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    @ApiOperation(value = "Fetches a specified Account Transaction.", notes = "Fetches an AccountTransaction corresponding to the transactionId input.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transactions Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getTransaction(
            @ApiParam(value = "The transactionId that is used to uniquely identify an AccountTransaction.",
                        example = "10009",
                        name = "transactionId",
                        required = true)
            @PathVariable("transactionId") final Long transactionId){

        AccountTransactionDto accountTransaction = fetchAccountTransactionService.getTransactionById(transactionId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
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

        AccountTransactionDto transactionResponse = createAccountTransactionService.createAccountTransaction(accountTransaction);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, transactionResponse);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @GetMapping("/{mnemonic}")
//    @ApiOperation(value = "Fetches a specified Account Transaction.", notes = "Fetches an AccountTransaction corresponding to the transactionId input.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Transactions Returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
//    })
//    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTypeValueFromTransactions(
//            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
//                    example = "MILES",
//                    name = "mnemonic",
//                    required = true)
//            @PathVariable("mnemonic") final Long transactionId){
//
//        AccountTransactionDto accountTransaction = fetchAccountTransactionService.getTransactionById(transactionId);
//        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @GetMapping("/{mnemonic}")
    @ApiOperation(value = "Calculates total value of AccountTransactions for an AccountType.", notes = "Calculates total value of an Account Type from all of its AccountTransactions.")
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

        Long accountValue = fetchAccountTransactionService.getTotalValueOfMnemonic(mnemonic);
        GeneralResponse<Long> response = new GeneralResponse<>(true, accountValue);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
