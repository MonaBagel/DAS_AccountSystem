package za.ac.nwu.das.repo.persistence;


import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.domain.persistence.AccountType;

@Repository
public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, Long> {

//    @Query(value = "SELECT " +
//            "           " +
//            "           acct " +
//            "       FROM " +
//            "           AccountType acct " +
//            "       WHERE acct.mnemonic = :accountTypeMnemonic ")
//    AccountType getAccountTypeByDbEntityMnemonic(String accountTypeMnemonic);
//    Long getTotalValueOfMnemonic(String mnemonic);


}