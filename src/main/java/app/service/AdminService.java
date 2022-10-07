package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.aspect.Logging;
import app.model.AdminAccount;
import app.repository.AdminRepository;
import app.util.Hash;
import app.util.Salt;

@Service
public class AdminService {
    private AdminRepository ar;

    @Autowired
    public AdminService(AdminRepository ar) {
        this.ar = ar;
    }

    @Transactional
    public String addAdmin(String adminname, String password) {
        Optional<AdminAccount> optional = this.ar.findById(adminname);

        if (!optional.isEmpty()) {
            Logging.LOG.error("Attempted to create an already-existing account");
            return "An account with that adminname already exists";

        }  else if (adminname.contains(" ")) {
            Logging.LOG.error("Included spaces");
            return "Adminname must not include spaces";

        } else if (adminname.equals("")) {
            Logging.LOG.error("Empty string");
            return "Adminname must not be empty";

        } else {
            String passwordSalt = Salt.generate();
            String passwordHash = Hash.SHA384toString(password + passwordSalt);
            AdminAccount account = new AdminAccount(adminname, passwordHash, passwordSalt, null, null);
            this.ar.save(account);
            Logging.LOG.info(adminname + " created");
            return "Account created!";
        }
    }

    // Optional feature: admins need a special code to sign up
    // Not implemented
    @Transactional
    public String addAdminCode(String adminname, String password, String code) {
        Optional<AdminAccount> optional = this.ar.findById(adminname);

        if (!optional.isEmpty()) {
            Logging.LOG.error("Attempted to create an already-existing account");
            return "An account with that adminname already exists";

        }  else if (adminname.contains(" ")) {
            Logging.LOG.error("Included spaces");
            return "Adminname must not include spaces";

        } else if (adminname.equals("")) {
            Logging.LOG.error("Empty string");
            return "Adminname must not be empty";

        } else {
            String passwordSalt = Salt.generate();
            String passwordHash = Hash.SHA384toString(password + passwordSalt);
            AdminAccount account = new AdminAccount(adminname, passwordHash, passwordSalt, null, null);
            this.ar.save(account);
            Logging.LOG.info(adminname + " created");
            return "Account created!";
        }
    }

    public String validateAdmin(String adminname, String password) {
        Optional<AdminAccount> optional = this.ar.findById(adminname);

        if (optional.isEmpty()) {
            Logging.LOG.error("Account does not exist");
            return "No account with that adminname exists";

        } else {
            AdminAccount admin = optional.get();
            String passwordSalt = admin.getPasswordSalt();
            String passwordHash = Hash.SHA384toString(password + passwordSalt);

            if (!passwordHash.equals(admin.getPasswordHash())) {
                Logging.LOG.error("Invalid password");
                return "Invalid password";
    
            } else {
                Logging.LOG.info(adminname + " signed in");
                return "Signed in!";
            }
        }
    }

    @Transactional
    public void deleteAccount(String adminname) {
        Logging.LOG.info(adminname + " deleted");
        this.ar.deleteById(adminname);
    }
}