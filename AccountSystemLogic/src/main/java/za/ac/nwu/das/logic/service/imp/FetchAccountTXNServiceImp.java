package za.ac.nwu.das.logic.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTXNDto;
import za.ac.nwu.das.logic.service.FetchAccountTXNService;
import za.ac.nwu.das.translator.AccountTXNTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTXNServiceImp implements FetchAccountTXNService {

    private final AccountTXNTranslator accountTXNTranslator;

    @Autowired
    public FetchAccountTXNServiceImp(AccountTXNTranslator accountTXNTranslator) {

        this.accountTXNTranslator = accountTXNTranslator;
    }

    @Override
    public List<AccountTXNDto> getAllTransactions(){

        return accountTXNTranslator.getAllTransactions();
    }



    @Override
    public List<AccountTXNDto> getAllAccountTypeTransactions(String mnemonic){

        return accountTXNTranslator.getAllAccountTypeTransactions(mnemonic);
    }

}
