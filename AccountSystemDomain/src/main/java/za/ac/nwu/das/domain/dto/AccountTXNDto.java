package za.ac.nwu.das.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.das.domain.persistence.AccountTXN;
import za.ac.nwu.das.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTXNDto implements Serializable {

    private static final long serialVersionUID = 6444250063290608195L;

    private Long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long transactionAmt;
    private LocalDate transactionDate;

    public AccountTXNDto() {
    }

    public AccountTXNDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long transactionAmt, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.transactionAmt = transactionAmt;
        this.transactionDate = transactionDate;
    }

    public AccountTXNDto(AccountTXN accountTXN) {
        this.transactionId = accountTXN.getTransactionId();
        this.accountTypeMnemonic = accountTXN.getAccountType().getMnemonic();
        this.memberId = accountTXN.getMemberId();
        this.transactionAmt = accountTXN.getTransactionAmt();
        this.transactionDate = accountTXN.getTransactionDate();
    }

    @JsonIgnore
    public AccountTXN buildAccountTransaction(AccountType accountType){
        return new AccountTXN(this.getTransactionId(), accountType, this.getMemberId(),
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


}
