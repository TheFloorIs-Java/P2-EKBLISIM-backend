package App.Controller;

import App.Service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    UserService us;
    public UserController(UserService us){
        this.us = us;
    }
    @GetMapping("shopping_cart")
    public int getTotalPrice() {
        return us.getTotalPrice();
    }
}
