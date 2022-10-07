package app.model;

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
    private String username;
    @Column(length = 384)
    private String passwordHash;
    @Column
    private String passwordSalt;

    private String password; // For receiving password from HTTP request that hasn't been hashed yet. This is not saved in the database
}