package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.UserAccount;
import app.repository.UserRepository;

@Service
public class UserService {
    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    @Transactional
    public String addUser(String username, String password) {
        Optional<UserAccount> optional = this.ur.findById(username);

        if (!optional.isEmpty()) {
            //this.logger.error("Attempted to create an already-existing account");
            return "An account with that username already exists";

        }  else if (username.contains(" ")) {
            //this.logger.error("Included spaces");
            return "Username must not include spaces";

        } else if (username.equals("")) {
            //this.logger.error("Empty string");
            return "Username must not be empty";

        } else {
            //this.logger.info(name + " created");
            UserAccount account = new UserAccount(username, Hash.SHA384toString(password), null);
            this.ur.save(account);
            return "Account created!";
        }
    }

    public String validateUser(String username, String password) {
        Optional<UserAccount> optional = this.ur.findById(username);

        if (optional.isEmpty()) {
            //this.logger.error("Account does not exist");
            return "No account with that username exists";

        } else if (!Hash.SHA384toString(password).equals(optional.get().getPasswordHash())) {
            //this.logger.error("Invalid password");
            return "Invalid password";

        } else {
            //this.logger.info(username + " signed in");
            return "Signed in!";
        }
    }

    @Transactional
    public void setAccount(UserAccount account) {
        //this.logger.info("Account updated");
        this.ur.save(account);
    }

    @Transactional
    public void deleteAccount(String username) {
        //this.logger.info("Account deleted");
        this.ur.deleteById(username);
    }
}