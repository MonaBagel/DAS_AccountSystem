package za.ac.nwu.das.logic.service.imp;

import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.domain.persistence.AccountType;
import za.ac.nwu.das.logic.service.CreateAccountTransactionService;
import za.ac.nwu.das.logic.service.FetchAccountTransactionService;
import za.ac.nwu.das.logic.service.FetchAccountTypeService;
import za.ac.nwu.das.translator.AccountTransactionTranslator;
import za.ac.nwu.das.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class CreateAccountTransactionServiceImp implements CreateAccountTransactionService {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final AccountTypeTranslator accountTypeTranslator;
    private final FetchAccountTypeService fetchAccountTypeService;


    public CreateAccountTransactionServiceImp(AccountTransactionTranslator accountTransactionTranslator,
                                              AccountTypeTranslator accountTypeTranslator,
                                              FetchAccountTypeService fetchAccountTypeService) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.accountTypeTranslator = accountTypeTranslator;
        this.fetchAccountTypeService = fetchAccountTypeService;
    }

    @Override
    public AccountTransactionDto createAccountTransaction(AccountTransactionDto accountTransactionDto) {

        accountTransactionDto.setTransactionId(null); // case where id has been filled in

        if(null == accountTransactionDto.getTransactionDate()){
            accountTransactionDto.setTransactionDate(LocalDate.now());
        }

        AccountType accountType = fetchAccountTypeService.getAccountTypeByDbEntityMnemonic(
                accountTransactionDto.getAccountTypeMnemonic());

        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        return new AccountTransactionDto(createdAccountTransaction);
    }


}
