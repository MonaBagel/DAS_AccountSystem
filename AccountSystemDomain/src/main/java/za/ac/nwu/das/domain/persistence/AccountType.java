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
    private Long mnemonic;

    private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    public AccountType(Long accountTypeId, Long mnemonic, String accountTypeName) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
    }

    @Id
    //@SequenceGenerator(name = "AUTO_INCREMENT", sequenceName = "proj1_das_demo.AUTO_INCREMENT", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_type_id")
    public Long getAccountTypeId() {
        return accountTypeId;
    }


    @Column(name = "mnemonic")
    public Long getMnemonic() {
        return mnemonic;
    }

    @Column(name = "account_type_name")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @OneToMany(targetEntity = AccountTransaction.class,
               fetch = FetchType.LAZY,
               mappedBy = "accountType",
               orphanRemoval = true,
               cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void AccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setMnemonic(Long mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic=" + mnemonic +
                ", accountTypeName=" + accountTypeName +
                '}';
    }
}
