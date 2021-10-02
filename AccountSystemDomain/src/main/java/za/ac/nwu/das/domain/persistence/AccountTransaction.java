package za.ac.nwu.das.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Account_Transaction", schema = "dbo")
public class AccountTransaction implements Serializable {

    @Id
    @SequenceGenerator(name = "DBO_GENERIC_SEQ",
            sequenceName = "dbo.DBO_GENERIC_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "DBO_GENERIC_SEQ")
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "account_type_id")
    private Long accountTypeId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "transaction_amount")
    private Long transactionAmt;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

}
