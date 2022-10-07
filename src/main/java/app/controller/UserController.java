package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.aspect.Logging;
import app.model.UserAccount;
import app.service.PaymentService;
import app.service.UserService;

@RestController
@CrossOrigin
public class UserController {
    private UserService us;
    // I would prefer to keep PaymentService separate from UserController, but I don't think JPA supports ON DELETE CASCADE for foreign keys, so this is neccessary
    private PaymentService ps;

    @Autowired
    public UserController(UserService us, PaymentService ps) {
        this.us = us;
        this.ps = ps;
    }

    @PostMapping("users")
    public String signUp(@RequestBody UserAccount account) { // Returns the error or success message defined in UserService.java
        Logging.LOG.info("Signing up");
        String username = account.getUsername();
        String message = this.us.addUser(username, account.getPassword());

        // Unnecessary but needed to maintain RESTful convention
        if (message.equals("Account created!")) {
            this.ps.defaultPayment(username);
        }

        return message;
    }
    
    @PostMapping("users/{username}")
    public String signIn(@PathVariable("username") String username, @RequestBody UserAccount account) { // Returns the error or success message defined in UserService.java
        Logging.LOG.info("Signing in");
        return this.us.validateUser(username, account.getPassword());
    }

    @PutMapping("users")
    public void updateAccount(@RequestBody UserAccount account) { // For changing the password
        Logging.LOG.info("Updating account information");
        this.us.updateAccount(account);
    }

    @DeleteMapping("users/{username}")
    public void deleteAccount(@PathVariable("username") String username) {
        Logging.LOG.info("Deleting " + username);
        this.us.deleteAccount(username);
        this.ps.deletePayment(username);
    }
}