package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Packages {
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

    //Many packages are chosen by one user
}
// GET request by the User, PUT request for the Admin to update a value