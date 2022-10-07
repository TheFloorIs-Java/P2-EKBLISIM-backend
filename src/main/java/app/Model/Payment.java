package app.model;

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
    private String username; // A primary key that's also a foreign key
    @OneToOne
    @PrimaryKeyJoinColumn
    private UserAccount userAccount;
    
    @Column
    private String cardNumber;
    @Column
    private String CVV;
    @Column
    private String expirationMonth;
    @Column
    private String expirationYear;
}