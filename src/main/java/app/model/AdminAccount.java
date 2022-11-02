package app.model;

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
    private String adminname;
    @Column
    private String passwordHash;

    private String password; // For receiving password from HTTP request that hasn't been hashed yet. This is not saved in the database
    private String signUpCode; // Optional feature: admins need a code to sign up
}