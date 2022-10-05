package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.AdminAccount;
import app.repository.AdminRepository;
import app.repository.UserRepository;

@Service
public class AdminService {
    private AdminRepository ar;
    private UserRepository ur;

    @Autowired
    public AdminService(AdminRepository ar, UserRepository ur) {
        this.ar = ar;
    }

    @Transactional
    public String addAdmin(String adminname, String password) {
        Optional<AdminAccount> optional = this.ar.findById(adminname);

        if (!optional.isEmpty()) {
            //this.logger.error("Attempted to create an already-existing account");
            return "An account with that adminname already exists";

        }  else if (adminname.contains(" ")) {
            //this.logger.error("Included spaces");
            return "Adminname must not include spaces";

        } else if (adminname.equals("")) {
            //this.logger.error("Empty string");
            return "Adminname must not be empty";

        } else {
            //this.logger.info(name + " created");
            AdminAccount account = new AdminAccount(adminname, Hash.SHA384toString(password), null, null);
            this.ar.save(account);
            return "Account created!";
        }
    }

    // Not implemented
    @Transactional
    public String addAdminCode(String adminname, String password, String code) { // Optional feature: admins need a special code to sign up
        Optional<AdminAccount> optional = this.ar.findById(adminname);

        if (!optional.isEmpty()) {
            //this.logger.error("Attempted to create an already-existing account");
            return "An account with that adminname already exists";

        }  else if (adminname.contains(" ")) {
            //this.logger.error("Included spaces");
            return "Adminname must not include spaces";

        } else if (adminname.equals("")) {
            //this.logger.error("Empty string");
            return "Adminname must not be empty";

        } else {
            //this.logger.info(name + " created");
            AdminAccount account = new AdminAccount(adminname, Hash.SHA384toString(password), null, null);
            this.ar.save(account);
            return "Account created!";
        }
    }

    public String validateAdmin(String adminname, String password) {
        Optional<AdminAccount> optional = this.ar.findById(adminname);

        if (optional.isEmpty()) {
            //this.logger.error("Account does not exist");
            return "No account with that adminname exists";

        } else if (!Hash.SHA384toString(password).equals(optional.get().getPasswordHash())) {
            //this.logger.error("Invalid password");
            return "Invalid password";

        } else {
            //this.logger.info(Adminname + " signed in");
            return "Signed in!";
        }
    }

    @Transactional
    public void deleteAccount(String adminname) {
        //this.logger.info("Account deleted");
        this.ar.deleteById(adminname);
    }

    @Transactional
    public void deleteUser(String username) {
        //this.logger.info("Account deleted");
        this.ur.deleteById(username);
    }
}