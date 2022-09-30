package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ShoppingCart {
    @Id
    @Column
    int cartId;
    @Column
    int orderNumber; // Foreign Key references packageId in Package
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name="orderNumber", nullable = false)
//    private Package pkg;
//    // Many shopping carts have the same package
//    @OneToOne(mappedBy = "Payment")
//    private Payment payment;
    // one shopping cart uses one payment in a single transaction
}
// GET request (to view items from the cart, calculate total price), POST request (to add items to the cart),
// DELETE request (to remove items from the cart) made here, all made by the User
