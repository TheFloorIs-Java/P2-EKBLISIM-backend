package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserAccount")
public class UserAccount {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int defaultId; // Must have a Primary Key
    @Column
    int userId; // Foreign Key referencing paymentId in Payment
    @Column
    String username;
    @Column
    String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "paymentId")
    private Payment payment;
    // One user uses one payment to make a transaction
}
