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
    String username;
    @Column
    int cardNumber;
    @Column
    int CVV;
    @Column
    int expirationDate;
}