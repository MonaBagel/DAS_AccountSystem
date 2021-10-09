package za.ac.nwu.das.logic.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.domain.persistence.AccountType;
import za.ac.nwu.das.logic.service.FetchAccountTransactionService;
import za.ac.nwu.das.logic.service.FetchAccountTypeService;
import za.ac.nwu.das.translator.AccountTransactionTranslator;
import za.ac.nwu.das.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountTransactionServiceImp implements FetchAccountTransactionService {

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
        return  accountTransactionDtos;

        //return accountTransactionTranslator.getAllTransactions();
    }

    @Override
    public AccountTransactionDto getTransactionById(Long transactionId) {

        AccountTransaction transaction = accountTransactionTranslator.getTransactionByPk(transactionId);
        return null != transaction ? new AccountTransactionDto(transaction) : null;
    }

    @Override
    public Long getTotalValueOfMnemonic(String mnemonic) {
        return accountTransactionTranslator.getTotalValueOfMnemonic(mnemonic);
    }


}
