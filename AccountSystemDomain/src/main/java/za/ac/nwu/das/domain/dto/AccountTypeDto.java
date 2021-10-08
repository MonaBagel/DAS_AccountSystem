package za.ac.nwu.das.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.das.domain.persistence.AccountType;
import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "AccountType",
        description = "A DTO that represents AccountType")
public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = -4472156901973962350L;

    private String mnemonic;
    private String accountTypeName;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String mnemonic, String accountTypeName) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
    }

    public AccountTypeDto(AccountType accountType){
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setMnemonic(accountType.getMnemonic());
    }

    @ApiModelProperty(position = 1,
            value =  "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getMnemonic(){
        return mnemonic;
    }

    private void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2,
            value =  "AccountType Name",
            name = "Name",
            notes = "The name of the AccountType",
            dataType = "java.lang.String",
            example = "Miles",
            required = true)
    public String getAccountTypeName(){ return accountTypeName; }

    private void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) obj;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName);
    }

    @JsonIgnore
    public AccountType getAccountType() {
        return new AccountType(this.getMnemonic(), this.getAccountTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                '}';
    }

}
