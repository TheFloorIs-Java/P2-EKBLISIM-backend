package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.AdminAccount;
import app.service.AdminService;

@RestController
public class AdminController {
    private AdminService as;

    @Autowired
    AdminController(AdminService as) {
        this.as = as;
    }

    @PostMapping("admins")
    public String signUp(@RequestBody AdminAccount account) { // Returns the error or success message defined in AdminService.java
        //this.logger.info("Signing up");
        return this.as.addAdmin(account.getAdminname(), account.getPasswordHash());
    }
    
    @PostMapping("admins/{name}")
    public String signIn(@RequestBody AdminAccount account) { // Returns the error or success message defined in AdminService.java
        //this.logger.info("Signing in");
        return this.as.validateAdmin(account.getAdminname(), account.getPasswordHash());
    }
}