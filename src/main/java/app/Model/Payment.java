package App.Model;

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
    int Id; // Foreign key references cartId in ShoppingCart
    @Column
    Long cardNumber;
    @Column
    int securityCode;
    @Column
    int expiryDate;
//    @OneToOne(mappedBy = "UserAccount")
//    private UserAccount users;
//    // a payment is made by one user
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Id", referencedColumnName = "cartId")
//    private ShoppingCart sc;
    // there is one payment used in a shopping cart
}
// POST request made here by the User
