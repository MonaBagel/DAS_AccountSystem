package za.ac.nwu.das.logic.service.implementation;

import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.logic.service.CreateAccountTypeService;
import za.ac.nwu.das.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class CreateAccountTypeServiceImp implements CreateAccountTypeService {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeServiceImp(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType){

//        if (null == accountTransaction.getTransactionDate()){
//            accountTransaction.setTransactionDate(LocalDate.now());
//        }
        return accountTypeTranslator.create(accountType);
    }

}

