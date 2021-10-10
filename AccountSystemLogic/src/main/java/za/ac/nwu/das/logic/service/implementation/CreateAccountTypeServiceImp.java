package za.ac.nwu.das.logic.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.logic.service.CreateAccountTypeService;
import za.ac.nwu.das.translator.AccountTypeTranslator;
import javax.transaction.Transactional;

@Transactional //Allows for rollback of application
@Component
public class CreateAccountTypeServiceImp implements CreateAccountTypeService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTypeServiceImp.class);

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeServiceImp(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto createAccountType(AccountTypeDto accountType){

        if(LOGGER.isDebugEnabled()){
            String loggingOutput = "";
            if(null != accountType){
                loggingOutput = accountType.toString();
            }
            LOGGER.debug("Input obj is {}",accountType);
        }

        AccountTypeDto accountTypeDTo = accountTypeTranslator.createAccountType(accountType);

        LOGGER.info("Return obj is {}", accountTypeDTo);

        return accountTypeDTo;
    }

}

