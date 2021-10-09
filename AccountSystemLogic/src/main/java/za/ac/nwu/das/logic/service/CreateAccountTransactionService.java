package za.ac.nwu.das.logic.service;

import za.ac.nwu.das.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionService {

    AccountTransactionDto createAccountTransaction(AccountTransactionDto accountTransaction);
    //AccountTransactionDto createNewTransaction();
}
