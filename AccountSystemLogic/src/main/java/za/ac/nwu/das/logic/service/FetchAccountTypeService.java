package za.ac.nwu.das.logic.service;

import za.ac.nwu.das.domain.dto.AccountTypeDto;
import java.util.List;

public interface FetchAccountTypeService {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
}
