package za.ac.nwu.das.logic.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.logic.service.FetchAccountTypeService;
import za.ac.nwu.das.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeServiceImp implements FetchAccountTypeService {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeServiceImp(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        return accountTypeTranslator.getAllAccountTypes();
    }

    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){

        return accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
    }


}
