package za.ac.nwu.das.logic.flow;

import za.ac.nwu.das.domain.dto.AccountTypeDto;
import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();
}
