package za.ac.nwu.das.translator.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.domain.persistence.AccountType;
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
    public List<AccountTransaction> getAllTransactions() {

        List<AccountTransaction> transactions = new ArrayList<>();
        try{
            transactions = new ArrayList<>(accountTransactionRepo.findAll());
        }catch(Exception ex){
            //TODO: log
            throw new RuntimeException("Unable to read from the DB", ex);
        }
        return transactions;
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

//    @Override
//    public Long getTotalValueOfMnemonic(String mnemonic) {
//        try{
//            //Long totalValue = accountTransactionRepo.getTotalValueOfMnemonic(mnemonic);
//            return null;
//        } catch (Exception ex) {
//            throw new RuntimeException("Unable to read from the DB", ex);
//        }
//    }

}
