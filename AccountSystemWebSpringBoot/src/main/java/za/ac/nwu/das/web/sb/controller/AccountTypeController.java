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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public AccountTypeController(FetchAccountTypeService fetchAccountTypeService, CreateAccountTypeService createAccountTypeService){

        this.fetchAccountTypeService = fetchAccountTypeService;
        this.createAccountTypeService = createAccountTypeService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account Types.", notes = "Returns a list of account types.")
    @ApiResponses(value ={
                  @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
                  @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                  @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
                  @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){

        List<AccountTypeDto> accountTypes = fetchAccountTypeService.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates a new AccountType in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The accountType was created succesfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "InternalServer Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new Account Type.",
            required = true)
            @RequestBody AccountTypeDto accountType){

        AccountTypeDto accountTypeResponse = createAccountTypeService.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    //create()
    //




}


