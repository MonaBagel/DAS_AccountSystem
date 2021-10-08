package za.ac.nwu.das.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "account_type", schema = "proj1_das_demo")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 2566762841659265490L;


    private Long accountTypeId;
    private String accountTypeName;
    private String mnemonic;

    //private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
    }

    public AccountType(String mnemonic, String accountTypeName) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_type_id")
    public Long getAccountTypeId() { return accountTypeId; }

    @Column(name = "mnemonic")
    public String getMnemonic() { return mnemonic; }

    @Column(name = "account_type_name")
    public String getAccountTypeName() { return accountTypeName; }

//    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType")
//    public Set<AccountTransaction> getAccountTransactions(){
//
//        return accountTransactions;
//    }

//    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
//        this.accountTransactions = accountTransactions;
//    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(mnemonic, that.mnemonic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, accountTypeName, mnemonic);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                '}';
    }
}
