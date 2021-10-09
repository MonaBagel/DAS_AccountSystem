package za.ac.nwu.das.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.das.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "SELECT (" +
            "         SUM(acxt.transactionAmt)) " +
            "       AS totalValue " +
            "       FROM " +
            "           AccountTransaction acxt " +
            "       JOIN " +
            "           AccountType acct " +
            "       WHERE acct.mnemonic = :mnemonic ")
    Long getTotalValueOfMnemonic(String mnemonic);



}