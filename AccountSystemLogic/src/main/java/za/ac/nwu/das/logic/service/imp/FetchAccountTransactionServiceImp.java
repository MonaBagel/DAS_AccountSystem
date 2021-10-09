package za.ac.nwu.das.logic.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.logic.service.FetchAccountTransactionService;
import za.ac.nwu.das.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountTransactionServiceImp implements FetchAccountTransactionService {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public FetchAccountTransactionServiceImp(AccountTransactionTranslator accountTransactionTranslator) {

        this.accountTransactionTranslator = accountTransactionTranslator;
    }


    @Override
    public List<AccountTransactionDto> getAllTransactions() {

        return accountTransactionTranslator.getAllTransactions();
    }

    @Override
    public AccountTransactionDto getTransactionById(Long transactionId) {

        AccountTransaction transaction = accountTransactionTranslator.getTransactionByPk(transactionId);

        return null != transaction ? new AccountTransactionDto(transaction) : null;
    }

}
