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

import app.model.Payment;
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
        //this.logger.info("Signing up");
        String message = this.us.addUser(account.getUsername(), account.getPassword());
        Boolean success = message.equals("Account created!");

        if (success) {
            this.ps.addPayment(new Payment(account.getUsername(), null, null, null, null, null));
        }

        return message;
    }
    
    @PostMapping("users/{username}")
    public String signIn(@RequestBody UserAccount account) { // Returns the error or success message defined in UserService.java
        //this.logger.info("Signing in");
        return this.us.validateUser(account.getUsername(), account.getPassword());
    }

    @PutMapping("users/{username}")
    public void setAccount(@RequestBody UserAccount account) { // For changing the password
        //this.logger.info("Updating account information");
        this.us.setAccount(account);
    }

    @DeleteMapping("users/{username}")
    public void deleteAccount(@PathVariable("username") String username) {
        //this.logger.info("Deleting " + username);
        this.us.deleteAccount(username);
    }

    @PutMapping("users/{username}/payment")
    public void updatePayment(@RequestBody Payment payment) { // For changing any payment details
        //this.logger.info("Updating payment information");
        this.ps.updatePayment(payment);
    }

    @GetMapping("users/{username}/payment")
    public Payment getPayment(@PathVariable("username") String username) {
        //this.logger.info("Retrieving payment information");
        return this.ps.getPayment(username);
    }

    // Shopping cart methods later, possibly
}