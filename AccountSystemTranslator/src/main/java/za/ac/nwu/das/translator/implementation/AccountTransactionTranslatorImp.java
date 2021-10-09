package za.ac.nwu.das.translator.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.repo.persistence.AccountTransactionRepo;
import za.ac.nwu.das.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImp implements AccountTransactionTranslator {

    private final AccountTransactionRepo accountTransactionRepo;

    @Autowired
    public AccountTransactionTranslatorImp(AccountTransactionRepo accountTransactionRepo) {

        this.accountTransactionRepo = accountTransactionRepo;
    }


    @Override
    public List<AccountTransactionDto> getAllTransactions() {

        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        try{
            for(AccountTransaction accountTransaction : accountTransactionRepo.findAll()){
                accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
            }
        }catch(Exception ex){
            //TODO: log
            throw new RuntimeException("Unable to read from the DB", ex);
        }
        return accountTransactionDtos;
    }

    @Override
    public AccountTransaction getTransactionByPk(Long transactionId) {

        try {
            return accountTransactionRepo.findById(transactionId).orElse(null);
        } catch (Exception ex){
            throw new RuntimeException("Unable to read from the DB", ex);
        }



    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {

        try{
            return accountTransactionRepo.save(accountTransaction);
        }catch (Exception ex){
            throw new RuntimeException("Unable to save to the DB", ex);
        }
    }


}
