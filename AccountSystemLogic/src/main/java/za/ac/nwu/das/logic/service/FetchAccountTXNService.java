package za.ac.nwu.das.logic.service;

import za.ac.nwu.das.domain.dto.AccountTXNDto;
import java.util.List;

public interface FetchAccountTXNService {

    List<AccountTXNDto> getAllAccountTypeTransactions(String mnemonic);
}
