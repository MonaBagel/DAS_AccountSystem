package za.ac.nwu.das.translator;

import za.ac.nwu.das.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {

    List<AccountTransactionDto> getAllTransactions();
}
