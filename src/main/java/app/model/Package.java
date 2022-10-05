package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Package {
    @Id
    @Column
    int ID;
    @Column
    String type;
    @Column
    String state;
    @Column
    String month;
    @Column
    String details;
    @Column
    double price;
}