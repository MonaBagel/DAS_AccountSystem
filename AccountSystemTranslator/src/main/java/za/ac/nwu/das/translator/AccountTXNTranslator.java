package za.ac.nwu.das.translator;

import za.ac.nwu.das.domain.dto.AccountTXNDto;

import java.util.List;

public interface AccountTXNTranslator {

    List<AccountTXNDto> getAllAccountTypeTransactions(String mnemonic);
}
