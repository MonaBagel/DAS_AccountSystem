package za.ac.nwu.das.domain.dto;

import za.ac.nwu.das.domain.persistence.AccountType;
import java.io.Serializable;

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

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                '}';
    }
}
