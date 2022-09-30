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
public class Package {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int packageID;
    @Column
    String packageType;
    @Column
    String usState;
    @Column
    String monthOffering;
    @Column
    String details;
    @Column
    double price;
//    @OneToMany(mappedBy = "Package", fetch = FetchType.LAZY,
//    cascade = CascadeType.ALL)
//    private List<ShoppingCart> carts;
    // One/Same package is in many shopping carts
}
// GET request by the User, PUT request for the Admin to update a value