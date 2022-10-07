package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.aspect.Logging;
import app.model.AdminAccount;
import app.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
    private AdminService as;

    @Autowired
    public AdminController(AdminService as) {
        this.as = as;
    }

    @PostMapping("admins")
    public String signUp(@RequestBody AdminAccount account) { // Returns the error or success message defined in AdminService.java
        Logging.LOG.info("Signing up");
        return this.as.addAdmin(account.getAdminname(), account.getPassword());
    }
    
    @PostMapping("admins/{adminname}")
    public String signIn(@RequestBody AdminAccount account) { // Returns the error or success message defined in AdminService.java
        Logging.LOG.info("Signing in");
        return this.as.validateAdmin(account.getAdminname(), account.getPassword());
    }

    @DeleteMapping("admins/{adminname}")
    public void deleteAccount(@PathVariable("adminname") String adminname) {
        Logging.LOG.info("Deleting " + adminname);
        this.as.deleteAccount(adminname);
    }
}