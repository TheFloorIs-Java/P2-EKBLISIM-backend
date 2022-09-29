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
@Table(name = "ShoppingCart")
public class ShoppingCart {
    @Id
    @Column
    int cartId;
    @Column
    int orderNumber; // Foreign Key references packageId in Package
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="orderNumber", nullable = false)
    private Package pkg;
    // Many shopping carts have the same package
    @OneToOne(mappedBy = "Payment")
    private Payment payment;
    // one shopping cart uses one payment in a single transaction
}
