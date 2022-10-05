package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.AdminAccount;
import app.service.AdminService;
import app.service.PackageService;

import app.model.Package;

@RestController
@CrossOrigin
public class AdminController {
    private AdminService as;
    private PackageService ps;

    @Autowired
    AdminController(AdminService as, PackageService ps) {
        this.as = as;
    }

    @PostMapping("admins")
    public String signUp(@RequestBody AdminAccount account) { // Returns the error or success message defined in AdminService.java
        //this.logger.info("Signing up");
        return this.as.addAdmin(account.getAdminname(), account.getPassword());
    }
    
    @PostMapping("admins/{adminname}")
    public String signIn(@RequestBody AdminAccount account) { // Returns the error or success message defined in AdminService.java
        //this.logger.info("Signing in");
        return this.as.validateAdmin(account.getAdminname(), account.getPassword());
    }

    @DeleteMapping("admins/{adminname}")
    public void deleteAccount(@PathVariable("adminname") String adminname) {
        //this.logger.info("Deleting " + adminname);
        this.as.deleteAccount(adminname);
    }

    @PostMapping("packages")
    public void addPackage(@RequestBody Package p) {
        this.ps.addPackage(p);
    }

    @GetMapping("packages/{id}")
    public Package getPackageByID(@PathVariable("id") Integer ID) {
        return this.ps.getPackageByID(ID);
    }

    @PutMapping("packages/{id}")
    public void updatePackage(@RequestBody Package p) {
        this.ps.updatePackage(p);
    }
}