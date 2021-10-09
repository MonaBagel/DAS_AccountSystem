package za.ac.nwu.das.logic.service.imp;

import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.logic.service.CreateAccountTypeService;
import za.ac.nwu.das.translator.AccountTypeTranslator;
import javax.transaction.Transactional;

@Transactional
@Component
public class CreateAccountTypeServiceImp implements CreateAccountTypeService {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeServiceImp(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto createAccountType(AccountTypeDto accountTypeDto){

        return accountTypeTranslator.createAccountType(accountTypeDto);
    }

}

