package za.ac.nwu.das.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.das.domain.dto.AccountTypeDto;
import za.ac.nwu.das.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
            "           acct " +
            "       FROM " +
            "           AccountType acct " +
            "       WHERE acct.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);



    @Query(value = "SELECT " +
            "           acct " +
            "       FROM " +
            "           AccountType acct " +
            "       WHERE acct.mnemonic = :accountTypeMnemonic ")
    AccountType getAccountTypeByDbEntityMnemonic(String accountTypeMnemonic);



}
