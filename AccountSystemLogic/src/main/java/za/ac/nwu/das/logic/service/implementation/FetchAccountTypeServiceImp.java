package za.ac.nwu.das.logic.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.domain.persistence.AccountType;
import za.ac.nwu.das.logic.service.FetchAccountTypeService;
import za.ac.nwu.das.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional //Allows for rollback of application
@Component
public class FetchAccountTypeServiceImp implements FetchAccountTypeService {

    public static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountTypeServiceImp.class);

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeServiceImp(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        List<AccountTypeDto> allAccountTypes = accountTypeTranslator.getAllAccountTypes();

        LOGGER.info("Returned list: {}", allAccountTypes);

        return allAccountTypes;
    }

    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){

        AccountTypeDto accountTypeByMnemonic = accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);

        LOGGER.info("Returned obj is {}", accountTypeByMnemonic);

        return accountTypeByMnemonic;
    }

    @Override
    public AccountType getAccountTypeByDbEntityMnemonic(String accountTypeMnemonic) {

        AccountType accountTypeByDbEntityMnemonic = accountTypeTranslator.getAccountTypeByDbEntityMnemonic(accountTypeMnemonic);

        LOGGER.info("Returned obj is {}", accountTypeByDbEntityMnemonic);

        return accountTypeByDbEntityMnemonic;
    }



}
