package za.ac.nwu.das.domain.dto;

import za.ac.nwu.das.domain.persistence.AccountTransaction;
import java.io.Serializable;
import java.time.LocalDate;

public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = 6444250063290608195L;

    private Long transactionAmt;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long transactionAmt, LocalDate transactionDate) {
        this.transactionAmt = transactionAmt;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction transaction){
        this.setTransactionAmt(transaction.getTransactionAmt());
        this.setTransactionDate(transaction.getTransactionDate());
    }

    public long getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(Long transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionAmt=" + transactionAmt +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
