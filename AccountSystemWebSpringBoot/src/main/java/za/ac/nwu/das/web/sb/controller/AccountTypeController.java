package za.ac.nwu.das.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.das.domain.dto.AccountTXNDto;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.domain.service.GeneralResponse;
import za.ac.nwu.das.logic.service.CreateAccountTypeService;
import za.ac.nwu.das.logic.service.FetchAccountTypeService;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTypeController {

    private final FetchAccountTypeService fetchAccountTypeService;
    private final CreateAccountTypeService createAccountTypeService;

    @Autowired
    public AccountTypeController(FetchAccountTypeService fetchAccountTypeService,
                                 CreateAccountTypeService createAccountTypeService){

        this.fetchAccountTypeService = fetchAccountTypeService;
        this.createAccountTypeService = createAccountTypeService;
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Gets all the configured Account Types.", notes = "Returns a list of account types.")
    @ApiResponses(value ={
                  @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
                  @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                  @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
                  @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAllAccountTypes(){

        List<AccountTypeDto> accountTypes = fetchAccountTypeService.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/create")
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates a new AccountType in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The accountType was created succesfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> createAccountType(
            @ApiParam(value = "Request body to create a new Account Type.",
            required = true)
            @RequestBody AccountTypeDto accountType){

        AccountTypeDto accountTypeResponse = createAccountTypeService.create(accountType);

        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/findBy {mnemonic}")
    @ApiOperation(value = "Fetches a specific AccountType", notes = "Fetches the AccountType corresponding to the given mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountType Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "AccountType Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType",
                        example = "MILES",
                        name = "mnemonic",
                        required = true)
            @PathVariable ("mnemonic") final String mnemonic){

        AccountTypeDto accountType = fetchAccountTypeService.getAccountTypeByMnemonic(mnemonic);

        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/viewAccountTypeValue")
//    @ApiOperation(value = "Calculates total value of an Account Type for a member", notes = "Fetches AccountTransactions amounts corresponding AccountType and calculates the total value")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "AccountType Value Calculated"),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Failed To Calculate Total Value", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
//    })
////    public ResponseEntity<GeneralResponse<AccountTXNDto>> calculateValue(){
////        @ApiParam(value = "The mnemonic that uniquely identifies the AccountType",
////                    example = "MILES",
////                    name = "mnemonic",
////                    required = true)
////        @PathVariable("mnemonic") final String mnemonic){
////
////    AccountTypeDto account
////        }
////
////
////    }

}


