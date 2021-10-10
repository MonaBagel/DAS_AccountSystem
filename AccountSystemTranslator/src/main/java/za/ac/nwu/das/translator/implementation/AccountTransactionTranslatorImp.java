package za.ac.nwu.das.translator.implementation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    //LOGGING
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountTransactionTranslatorImp.class);

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

            if(LOGGER.isDebugEnabled()){
                LOGGER.error("Exception getting list of transactions: " + ex.getMessage());
            }

            throw new RuntimeException("Unable to read from the DB", ex);
        }
        return transactions;
    }

    @Override
    public AccountTransaction getTransactionByPk(Long transactionId) {

        try {
            return accountTransactionRepo.findById(transactionId).orElse(null);

        } catch (Exception ex){
            if(LOGGER.isDebugEnabled()) {
                LOGGER.error("Exception getting transaction by PK: " + ex.getMessage());
            }

            throw new RuntimeException("Unable to read from the DB", ex);
        }
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {

        try{
            return accountTransactionRepo.save(accountTransaction);

        }catch (Exception ex){
            if(LOGGER.isDebugEnabled()) {
                LOGGER.error("Exception when writing new transaction to db: " + ex.getMessage());
            }

            throw new RuntimeException("Unable to save to the DB", ex);

        }
    }

    @Override
    public Long getTotalValueOfMnemonic(String mnemonic) {
        try{
            return accountTransactionRepo.getTotalValueOfMnemonic(mnemonic);

        } catch (Exception ex){
            if(LOGGER.isDebugEnabled()) {
                LOGGER.error("Exception when reading transactions and calculating value of an Account Type: " + ex.getMessage());
            }

            throw new RuntimeException("Unable to read from the DB", ex);

        }
    }
}
