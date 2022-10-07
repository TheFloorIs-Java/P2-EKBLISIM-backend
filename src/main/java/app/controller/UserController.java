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

        // I don't even know if ON DELETE CASCADE is possible in JPA, so UserController needs PaymentService now
        if (message.equals("Account created!")) {
            this.ps.defaultPayment(username);
        }

        return message;    }
    
    @PostMapping("users/{username}")
    public String signIn(@RequestBody UserAccount account) { // Returns the error or success message defined in UserService.java
        Logging.LOG.info("Signing in");
        return this.us.validateUser(account.getUsername(), account.getPassword());
    }

    @PutMapping("users/{username}")
    public void setAccount(@RequestBody UserAccount account) { // For changing the password
        Logging.LOG.info("Updating account information");
        this.us.setAccount(account);
    }

    @DeleteMapping("users/{username}")
    public void deleteAccount(@PathVariable("username") String username) {
        Logging.LOG.info("Deleting " + username);
        this.us.deleteAccount(username);
        this.ps.deletePayment(username);
    }
}