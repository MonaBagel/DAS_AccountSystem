package za.ac.nwu.das.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.das.domain.persistence.AccountTransaction;
import java.io.Serializable;
import java.time.LocalDate;

public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = 6444250063290608195L;

    //private Long memberId;
    private Long transactionAmt;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(/*Long memberId,*/ Long transactionAmt, LocalDate transactionDate) {
        //this.memberId = memberId;
        this.transactionAmt = transactionAmt;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction transaction){
        this.setTransactionAmt(transaction.getTransactionAmt());
        this.setTransactionDate(transaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value =  "AccountTransaction Amount",
            name = "Mnemonic",
            notes = "Total amount for transaction",
            dataType = "java.lang.Long",
            example = "150",
            allowEmptyValue = false,
            required = true)
    public long getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(Long transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    @ApiModelProperty(position = 2,
            value =  "AccountTransaction Amount",
            name = "Mnemonic",
            notes = "Total amount for transaction",
            dataType = "java.lang.Long",
            example = "2021-01-01",
            allowEmptyValue = true,
            required = false)
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
