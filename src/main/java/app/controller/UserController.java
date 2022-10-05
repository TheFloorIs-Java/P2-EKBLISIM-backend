package App.controller;

import App.Model.UserAccount;
import App.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    UserService us;
    public UserController(UserService us){
        this.us = us;
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
    @GetMapping("cart")
    public int getTotalPrice() {
        return us.getTotalPrice();
    }
}
