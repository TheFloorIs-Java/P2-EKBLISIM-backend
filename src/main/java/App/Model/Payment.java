package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @Column
    int paymentId;
    @Column
    int Id; // Foreign key references cartId in ShoppingCart
    @Column
    int cardNumber;
    @Column
    int securityCode;
    @Column
    int expiryDate;
    @OneToOne(mappedBy = "UserAccount")
    private UserAccount users;
    // a payment is made by one user
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id", referencedColumnName = "cartId")
    private ShoppingCart sc;
    // there is one payment used in a shopping cart
}
