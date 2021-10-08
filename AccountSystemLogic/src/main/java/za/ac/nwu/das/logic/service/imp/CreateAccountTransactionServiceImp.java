package za.ac.nwu.das.logic.service.imp;

import org.springframework.stereotype.Component;
import za.ac.nwu.das.logic.service.CreateAccountTransactionService;
import za.ac.nwu.das.translator.AccountTransactionTranslator;
import javax.transaction.Transactional;

@Transactional
@Component
public class CreateAccountTransactionServiceImp implements CreateAccountTransactionService {

    private final AccountTransactionTranslator accountTransactionTranslator;

    public CreateAccountTransactionServiceImp(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

//    @Override
//    public AccountTransactionDto createAccountType(AccountTransactionDto accountTransaction){
//
//        if (null == accountTransaction.getTransactionDate()){
//            accountTransaction.setTransactionDate(LocalDate.now());
//        }
//        return accountTransactionTranslator.createAccountTransaction(accountType);
//    }

}
