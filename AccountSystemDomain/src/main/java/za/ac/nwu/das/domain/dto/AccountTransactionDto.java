package za.ac.nwu.das.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import za.ac.nwu.das.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = 6444250063290608195L;

    private Long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long transactionAmt;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long transactionAmt, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.transactionAmt = transactionAmt;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.transactionId = accountTransaction.getTransactionId();
        this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.memberId = accountTransaction.getMemberId();
        this.transactionAmt = accountTransaction.getTransactionAmt();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType){
        return new AccountTransaction(this.getTransactionId(), accountType, this.getMemberId(),
                this.getTransactionAmt(), this.getTransactionDate());
    }

    public Long getTransactionId() { return transactionId; }

    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }


    public String getAccountTypeMnemonic() { return accountTypeMnemonic; }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) { this.accountTypeMnemonic = accountTypeMnemonic; }


    public Long getMemberId() { return memberId; }

    public void setMemberId(Long memberId) { this.memberId = memberId; }


    public Long getTransactionAmt() { return transactionAmt; }

    public void setTransactionAmt(Long transactionAmt) { this.transactionAmt = transactionAmt; }


    public LocalDate getTransactionDate() { return transactionDate; }

    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic) && Objects.equals(memberId, that.memberId) && Objects.equals(transactionAmt, that.transactionAmt) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeMnemonic, memberId, transactionAmt, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", memberId=" + memberId +
                ", transactionAmt=" + transactionAmt +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
