package za.ac.nwu.das.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.das.domain.persistence.AccountTXN;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTXNDto implements Serializable {

    private static final long serialVersionUID = 6444250063290608195L;

    private Long transactionAmt;
    private LocalDate transactionDate;

    public AccountTXNDto() {
    }

    public AccountTXNDto(Long transactionAmt, LocalDate transactionDate) {
        this.transactionAmt = transactionAmt;
        this.transactionDate = transactionDate;
    }

    public AccountTXNDto(AccountTXN transaction){
        this.setTransactionAmt(transaction.getTransactionAmt());
        this.setTransactionDate(transaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value =  "AccountTransaction Amount",
            name = "Transaction Amount",
            notes = "Total amount for transaction: negative numbers for subtraction, positive numbers for addition",
            dataType = "java.lang.Long",
            example = "-150 or 150",
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AccountTXNDto that = (AccountTXNDto) obj;
        return Objects.equals(transactionAmt, that.transactionAmt) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionAmt, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionAmt=" + transactionAmt +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
