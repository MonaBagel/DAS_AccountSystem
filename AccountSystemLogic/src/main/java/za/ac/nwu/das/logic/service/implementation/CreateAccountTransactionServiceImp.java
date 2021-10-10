package za.ac.nwu.das.logic.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.domain.persistence.AccountType;
import za.ac.nwu.das.logic.service.CreateAccountTransactionService;
import za.ac.nwu.das.logic.service.FetchAccountTypeService;
import za.ac.nwu.das.translator.AccountTransactionTranslator;
import za.ac.nwu.das.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional //Allows for rollback of application
@Component
class CreateAccountTransactionServiceImp implements CreateAccountTransactionService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionServiceImp.class);

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

        if(LOGGER.isDebugEnabled()){
            String loggingOutput = "";
            if(null != accountTransactionDto){
                loggingOutput = accountTransactionDto.toString();
            }
            LOGGER.debug("Input obj is {}", accountTransactionDto);
        }

        accountTransactionDto.setTransactionId(null); // clears id input for pk auto-generate in db

        if(null == accountTransactionDto.getTransactionDate()){
            accountTransactionDto.setTransactionDate(LocalDate.now());
        }

        AccountType accountType = fetchAccountTypeService.getAccountTypeByDbEntityMnemonic(
                accountTransactionDto.getAccountTypeMnemonic());

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Fetched AccountType for {}, AccountTypeId is {}", accountTransactionDto.getAccountTypeMnemonic(),
                    accountType.getAccountTypeId());
        }
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        AccountTransactionDto results = new AccountTransactionDto(createdAccountTransaction);
        LOGGER.info("Return obj is {}", accountTransactionDto);
        return results;
    }


}
