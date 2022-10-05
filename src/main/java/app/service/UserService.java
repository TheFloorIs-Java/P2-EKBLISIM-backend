package App.service;

import App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    UserRepository ur;
    @Autowired
    public UserService(UserRepository ur){
        this.ur = ur;
    }
    public int getTotalPrice(){
        return ur.getTotalPrice();
    }
}
