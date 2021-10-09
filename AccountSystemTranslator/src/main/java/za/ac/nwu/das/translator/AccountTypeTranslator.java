package za.ac.nwu.das.translator;

import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTranslator {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto createAccountType(AccountTypeDto accountType);

    AccountType getAccountTypeByDbEntityMnemonic(String accountTypeMnemonic);

}
