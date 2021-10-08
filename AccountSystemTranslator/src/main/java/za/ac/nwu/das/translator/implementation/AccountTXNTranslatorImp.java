package za.ac.nwu.das.translator.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTXNDto;
import za.ac.nwu.das.domain.persistence.AccountTXN;
import za.ac.nwu.das.repo.persistence.AccountTXNRepo;
import za.ac.nwu.das.translator.AccountTXNTranslator;
import za.ac.nwu.das.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTXNTranslatorImp implements AccountTXNTranslator {

    private final AccountTXNRepo accountTXNRepo;

    @Autowired
    public AccountTXNTranslatorImp(AccountTXNRepo accountTXNRepo) {

        this.accountTXNRepo = accountTXNRepo;
    }


    @Override
    public List<AccountTXNDto> getAllAccountTypeTransactions(String mnemonic){

        List<AccountTXNDto> accountTXNDtos = new ArrayList<>();
        try{
            for(AccountTXN accountTransaction : accountTXNRepo.findAll()){
                accountTXNDtos.add(new AccountTXNDto(accountTransaction));
            }
        }catch (Exception ex){
            //TODO: log
            throw new RuntimeException("Unable to read from the DB", ex);
        }
        return accountTXNDtos;
    }


}
