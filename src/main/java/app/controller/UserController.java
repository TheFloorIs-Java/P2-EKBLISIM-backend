package App.controller;

import App.Model.UserAccount;
import App.service.PaymentService;
import App.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    UserService us;
    private PaymentService ps;
    public UserController(UserService us, PaymentService ps){
        this.us = us;
        this.ps = ps;
    }

    @PostMapping("users")
    public String signUp(@RequestBody UserAccount account) { // Returns the error or success message defined in UserService.java
        return this.us.addUser(account.getUsername(), account.getPassword());
    } // gives "java.lang.NullPointerException: Cannot invoke "java.util.Optional.isEmpty()" because "optional" is null"
    @GetMapping("logins")
    public List<UserAccount> getUsers(){
        return us.getUsers();
    }
    @PostMapping("users/{username}")
    public String signIn(@RequestBody UserAccount account) { // Returns the error or success message defined in UserService.java
        return this.us.validateUser(account.getUsername(), account.getPassword());
    } // I am unable to sign in

//    @GetMapping("users/{username}/payment")
//    public Payment getPayment(@PathVariable("username")String username) {
//        //this.logger.info("Retrieving payment information");
//        return this.ps.getPayment(username);
//    }
}
