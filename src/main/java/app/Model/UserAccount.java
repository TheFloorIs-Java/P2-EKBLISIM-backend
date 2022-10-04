package App.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class UserAccount {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId; // Foreign Key referencing paymentId in Payment
    @Column
    String username; // we can join this with paymentId
    @Column
    String password;
    @OneToMany(mappedBy = "userAccount")
    @JsonManagedReference
    List<Packages> packages;
    @OneToMany(mappedBy = "userpays")
    @JsonManagedReference
    List<Payment> payments;
//     One user can add many packages
}

