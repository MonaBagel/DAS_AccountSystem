package za.ac.nwu.das.translator;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator{

    List<AccountTransaction> getAllTransactions();

    AccountTransaction getTransactionByPk(Long transactionId);

    AccountTransaction save(AccountTransaction accountTransaction);

    Long getTotalValueOfMnemonic(String mnemonic);

}
