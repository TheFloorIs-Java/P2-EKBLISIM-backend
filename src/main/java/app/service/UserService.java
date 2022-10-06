package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.aspect.Logging;
import app.model.UserAccount;
import app.repository.UserRepository;
import app.util.Hash;

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
            Logging.LOG.error("Attempted to create an already-existing account");
            return "An account with that username already exists";

        }  else if (username.contains(" ")) {
            Logging.LOG.error("Included spaces");
            return "Username must not include spaces";

        } else if (username.equals("")) {
            Logging.LOG.error("Empty string");
            return "Username must not be empty";

        } else {
            UserAccount account = new UserAccount(username, Hash.SHA384toString(password), null);
            this.ur.save(account);
            Logging.LOG.info(username + " created");
            return "Account created!";
        }
    }

    public String validateUser(String username, String password) {
        Optional<UserAccount> optional = this.ur.findById(username);

        if (optional.isEmpty()) {
            Logging.LOG.error("Account does not exist");
            return "No account with that username exists";

        } else if (!Hash.SHA384toString(password).equals(optional.get().getPasswordHash())) {
            Logging.LOG.error("Invalid password");
            return "Invalid password";

        } else {
            Logging.LOG.info(username + " signed in");
            return "Signed in!";
        }
    }

    public UserAccount getAccount(String username) {
        return this.ur.findById(username).get();
    }

    @Transactional
    public void setAccount(UserAccount account) {
        Logging.LOG.info("Account updated");
        this.ur.save(account);
    }

    @Transactional
    public void deleteAccount(String username) {
        Logging.LOG.info(username + " deleted");
        this.ur.deleteById(username);
    }
}