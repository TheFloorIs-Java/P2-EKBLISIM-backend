package app.service;

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
        UserAccount account = this.ur.getAccount(username);

        if (account != null) {
            //this.logger.error("Attempted to create an already existing account");
            return "An account with that username already exists";

        }  else if (username.contains(" ")) {
            //this.logger.error("Included spaces");
            return "Username must not include spaces";

        } else if (username.equals("")) {
            //this.logger.error("Empty string");
            return "Username must not be empty";

        } else {
            //this.logger.info(name + " created");
            account = new UserAccount(username, Hash.SHA384toString(password));
            this.ur.save(account);
            return "Account created!";
        }
    }

    public String validateUser(String username, String password) {
        UserAccount account = this.ur.getAccount(username);

        if (account == null) {
            //this.logger.error("Account does not exist");
            return "No account with that username exists";

        } else if (!Hash.maps(password, account.getPasswordHash())) {
            //this.logger.error("Invalid password");
            return "Invalid password";

        } else {
            //this.logger.info(username + " signed in");
            return "Signed in!";
        }
    }
}