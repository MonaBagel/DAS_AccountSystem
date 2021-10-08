package za.ac.nwu.das.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.das.domain.dto.AccountTXNDto;
import za.ac.nwu.das.domain.service.GeneralResponse;
import za.ac.nwu.das.logic.service.CreateAccountTXNService;
import za.ac.nwu.das.logic.service.CreateAccountTypeService;
import za.ac.nwu.das.logic.service.FetchAccountTXNService;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final FetchAccountTXNService fetchAccountTXNService;
    //private final CreateAccountTXNService createAccountTXNService;


    @Autowired
    public AccountTransactionController(FetchAccountTXNService fetchAccountTXNService/*,
                                        CreateAccountTXNService createAccountTXNService*/){
        this.fetchAccountTXNService = fetchAccountTXNService;
        //this.createAccountTXNService = createAccountTXNService;
    }

//    public ResponseEntity<GeneralResponse<List<AccountTXNDto>>> getAllTransactions(){
//
//    }

    @GetMapping("/findBy {AccountType mnemonic}")
    @ApiOperation(value = "Fetches transactions for a specific AccountType", notes = "Fetches AccountTransactions corresponding to the given AccountType mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountType Transactions Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "AccountType Transactions Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTXNDto>>> getAllTransactionsByAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies an AccountType",
                        example = "MILES",
                        name = "mnemonic",
                        required = true)
            @PathVariable ("mnemonic") final String mnemonic){

        List<AccountTXNDto> accountTransactions = fetchAccountTXNService.getAllAccountTypeTransactions(mnemonic);
        GeneralResponse<List<AccountTXNDto>> response = new GeneralResponse<>(true, accountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


//    public ResponseEntity<GeneralResponse<AccountTXNDto>> createTransaction(){
//
//    }


    //getAllTransactions()
    //createNewTransaction()
    //subractAmountTransaction()
    //addAmountTransaction()












}
