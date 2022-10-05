package App.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    long cardNumber; // issue: accepts values less and greater than 16 digits
    @Column
    int securityCode;
    @Column
    int expiryDate; // issue: how to do a date format, I tried assigning it to String, gave me an error
//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name="username")
//    UserAccount userpays;
    @OneToOne(mappedBy = "payments")
    private UserAccount userpays;
// One payment is used in one order by a single user
}
// POST request made here by the User
