package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.Payment;
import app.model.UserAccount;
import app.service.PaymentService;
import app.service.UserService;

@RestController
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
        //this.logger.info("Signing up");
        return this.us.addUser(account.getUsername(), account.getPasswordHash());
    }
    
    @PostMapping("users/{username}")
    public String signIn(@RequestBody UserAccount account) { // Returns the error or success message defined in UserService.java
        //this.logger.info("Signing in");
        return this.us.validateUser(account.getUsername(), account.getPasswordHash());
    }

    @PostMapping("users/{username}/payment")
    public void updatePayment(@PathVariable("username") Payment payment) {
        //this.logger.info("Retrieving payment information");
        this.ps.updatePayment(payment);
    }

    @GetMapping("users/{username}/payment")
    public Payment getPayment(@PathVariable("username") String username) {
        //this.logger.info("Retrieving payment information");
        return this.ps.getPayment(username);
    }

    // Shopping cart methods later, possibly
}