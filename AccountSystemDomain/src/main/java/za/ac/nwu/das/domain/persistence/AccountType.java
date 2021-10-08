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

    private Set<AccountTXN> accountTXNS;

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

    @OneToMany(targetEntity = AccountTXN.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTXN> getAccountTransactions(){

        return accountTXNS;
    }

    public void setAccountTransactions(Set<AccountTXN> accountTXNS) {
        this.accountTXNS = accountTXNS;
    }

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AccountType that = (AccountType) obj;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTXNS, that.accountTXNS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, accountTypeName, mnemonic, accountTXNS);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTransactions=" + accountTXNS +
                '}';
    }


}
