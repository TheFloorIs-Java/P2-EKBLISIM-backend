package App.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Payment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int paymentId;
    @Column
    @NotNull
    long cardNumber; // issue: accepts values less and greater than 16 digits
    @Column
    @NotNull
    int securityCode;
    @Column
    @NotNull
    String expiryDate;

//    @OneToOne(mappedBy = "payments")
//    private UserAccount userpays;
// One payment is used in one order by a single user
}
// POST request made here by the User
