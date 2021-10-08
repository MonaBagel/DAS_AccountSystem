package za.ac.nwu.das.logic.service;

import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import java.util.List;

public interface FetchAccountTransactionService {

    List<AccountTransactionDto> getAllTransactions();

    List<AccountTransactionDto> getAllAccountTypeTransactions(String mnemonic);
}
