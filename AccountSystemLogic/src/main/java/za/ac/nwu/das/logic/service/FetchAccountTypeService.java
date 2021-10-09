package za.ac.nwu.das.logic.service;

import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.domain.persistence.AccountType;

import java.util.List;

public interface FetchAccountTypeService {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountType getAccountTypeByDbEntityMnemonic(String accountTypeMnemonic);
}
