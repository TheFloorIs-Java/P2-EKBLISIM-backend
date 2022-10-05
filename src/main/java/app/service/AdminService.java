package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.AdminAccount;
import app.repository.AdminRepository;

@Service
public class AdminService {
    private AdminRepository ar;

    @Autowired
    public AdminService(AdminRepository ar) {
        this.ar = ar;
    }

    @Transactional
    public String addAdmin(String adminname, String password) {
        AdminAccount account = this.ar.getAdmin(adminname);

        if (account != null) {
            //this.logger.error("Attempted to create an already existing account");
            return "An account with that adminname already exists";

        }  else if (adminname.contains(" ")) {
            //this.logger.error("Included spaces");
            return "Adminname must not include spaces";

        } else if (adminname.equals("")) {
            //this.logger.error("Empty string");
            return "Adminname must not be empty";

        } else {
            //this.logger.info(name + " created");
            account = new AdminAccount(adminname, Hash.SHA384toString(password));
            this.ar.save(account);
            return "Account created!";
        }
    }

    public String validateAdmin(String adminname, String password) {
        AdminAccount account = this.ar.getAdmin(adminname);

        if (account == null) {
            //this.logger.error("Account does not exist");
            return "No account with that adminname exists";

        } else if (!Hash.maps(password, account.getPasswordHash())) {
            //this.logger.error("Invalid password");
            return "Invalid password";

        } else {
            //this.logger.info(Adminname + " signed in");
            return "Signed in!";
        }
    }
}