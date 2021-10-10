package za.ac.nwu.das.logic.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.logic.service.FetchAccountTransactionService;
import za.ac.nwu.das.logic.service.FetchAccountTypeService;
import za.ac.nwu.das.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional //Allows for rollback of application
@Component
public class FetchAccountTransactionServiceImp implements FetchAccountTransactionService {

    public static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountTransactionServiceImp.class);

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeService fetchAccountTypeService;

    @Autowired
      public FetchAccountTransactionServiceImp(AccountTransactionTranslator accountTransactionTranslator,
                                               FetchAccountTypeService fetchAccountTypeService) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeService = fetchAccountTypeService;
    }

    @Override
    public List<AccountTransactionDto> getAllTransactions() {

        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        for(AccountTransaction accountTransaction : accountTransactionTranslator.getAllTransactions()){
            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
        }

        LOGGER.info("Returned list is {}", accountTransactionDtos);

        return  accountTransactionDtos;

    }

    @Override
    public AccountTransactionDto getTransactionById(Long transactionId) {

        if(LOGGER.isDebugEnabled()){
            String loggingOutput = "";
            if(null != transactionId){
                loggingOutput = transactionId.toString();
            }
            LOGGER.debug("Input value is {}", transactionId);
        }

        AccountTransaction transaction = accountTransactionTranslator.getTransactionByPk(transactionId);
        AccountTransactionDto accountTransactionDto = null != transaction ? new AccountTransactionDto(transaction) : null;

        LOGGER.info("Return obj is {}", accountTransactionDto);

        return accountTransactionDto;
    }

    @Override
    public Long getTotalValueOfMnemonic(String mnemonic) {

        if(LOGGER.isDebugEnabled()){
            String loggingOutput = "";
            if(null != mnemonic){
                loggingOutput = mnemonic;
            }
            LOGGER.debug("Input value is {}", mnemonic);
        }

        Long totalValueOfMnemonic = accountTransactionTranslator.getTotalValueOfMnemonic(mnemonic);

        LOGGER.info("Return obj is {}", totalValueOfMnemonic);

        return totalValueOfMnemonic;
    }


}
