package za.ac.nwu.das.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Account_Transaction", schema = "dbo")
public class AccountType implements Serializable {

    private static final long serialVersionUID = -2845191564523985042L;

    @Id
    @SequenceGenerator(name = "DBO_GENERIC_SEQ",
                       sequenceName = "dbo.DBO_GENERIC_SEQ",
                       allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "DBO_GENERIC_SEQ")
    @Column(name = "account_type_id")
    private Long accountTypeId;

    @Column(name = "mnemonic")
    private Long mnemonic;

    @Column(name = "account_type_name")
    private Long accountTypeName;








    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic=" + mnemonic +
                ", accountTypeName=" + accountTypeName +
                '}';
    }
}
