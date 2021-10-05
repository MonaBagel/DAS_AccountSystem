package za.ac.nwu.das.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.das.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, Long> {
}
