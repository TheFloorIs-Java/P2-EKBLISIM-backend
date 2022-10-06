package App.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAccount {
    @Id
    @Column
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int userId;
//    @Column
    private String username; // we can join this with paymentId
    @Column(length = 384)
    private String passwordHash;
    private String password;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "paymentId")
//    private Payment payments;
    // One user makes one payment per order
//    public UserAccount(String username, String sha384toString, Object o) {
//    }

}

