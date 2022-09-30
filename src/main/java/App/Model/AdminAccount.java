package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdminAccount {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int adminId;
    @Column
    String username;
    @Column
    String password;
}
