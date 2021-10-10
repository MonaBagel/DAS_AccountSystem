package za.ac.nwu.das.translator.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.domain.persistence.AccountType;
import za.ac.nwu.das.repo.persistence.AccountTypeRepo;
import za.ac.nwu.das.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImp implements AccountTypeTranslator {

    public static final Logger LOGGER = LoggerFactory.getLogger(AccountTypeTranslatorImp.class);

    private final AccountTypeRepo accountTypeRepo;

    @Autowired
    public AccountTypeTranslatorImp(AccountTypeRepo accountTypeRepo){

        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try{
            for(AccountType accountType : accountTypeRepo.findAll()){
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        }catch (Exception ex){
            if(LOGGER.isDebugEnabled()){
                LOGGER.error("Exception when fetching all accountTypes: " + ex.getMessage());
            }

            throw new RuntimeException("Unable to read from the DB", ex);
        }
        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        try{
            AccountType accountType = accountTypeRepo.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }catch(Exception ex){
            if(LOGGER.isDebugEnabled()){
                LOGGER.error("Exception when fetching accountType by mnemonic: " + ex.getMessage());
            }
            throw new RuntimeException("Unable to read from the DB", ex);
        }
    }


    @Override
    public AccountTypeDto createAccountType(AccountTypeDto accountTypeDto) {

        try{
            AccountType accountType = accountTypeRepo.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }catch(Exception ex){
            if(LOGGER.isDebugEnabled()){
                LOGGER.error("Exception when creating a new accountType: " + ex.getMessage());
            }
            throw new RuntimeException("Unable to save to the DB", ex);
        }

    }

    @Override
    public AccountType getAccountTypeByDbEntityMnemonic(String accountTypeMnemonic) {
        try{
            AccountType accountType = accountTypeRepo.getAccountTypeByMnemonic(accountTypeMnemonic);
            return accountType;
        }catch(Exception ex){

            if(LOGGER.isDebugEnabled()){
                LOGGER.error("Exception when fetching accountType by mnemonic: " + ex.getMessage());
            }

            throw new RuntimeException("Unable to read from the DB", ex);
        }
    }


}
