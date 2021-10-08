package za.ac.nwu.das.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.das.domain.dto.AccountTransactionDto;
import za.ac.nwu.das.domain.persistence.AccountTransaction;

import java.util.List;

@Repository
public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "SELECT account_type_name, transaction_amount, transaction_date" +
                    "FROM account_transaction" +
                    "INNER JOIN account_type" +
                    "ON account_transaction.account_type_id = account_type.account_type_id" +
                    "WHERE member_id = 1" +
                    "AND account_type.mnemonic = :mnemonic ", nativeQuery = true)
    List<AccountTransactionDto> getAllAccountTypeTransactions(String mnemonic);
}
