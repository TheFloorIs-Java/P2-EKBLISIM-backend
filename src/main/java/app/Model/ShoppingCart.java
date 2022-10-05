package app.model;
/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ShoppingCart")
@Table(name = "ShoppingCart")
public class ShoppingCart {
    @Id
    @Column
    int ID;
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
*/