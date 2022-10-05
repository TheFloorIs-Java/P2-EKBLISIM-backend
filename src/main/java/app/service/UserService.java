package App.service;

import App.Model.UserAccount;
import App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {
    UserRepository ur;
    @Autowired
    public UserService(UserRepository ur){
        this.ur = ur;
    }
    @Transactional
    public String addUser(String username, String password) {
        UserAccount account = this.ur.getAccount(username);

        if (account != null) {
            return "An account with that username already exists";

        }  else if (username.contains(" ")) {
            return "Username must not include spaces";

        } else if (username.equals("")) {
            return "Username must not be empty";

        } else {
            account = new UserAccount(username, Hash.SHA384toString(password));
            this.ur.save(account);
            return "Account created!";
        }
    }

    public String validateUser(String username, String password) {
        UserAccount account = this.ur.getAccount(username);

        if (account == null) {
            return "No account with that username exists";

        } else if (!Hash.maps(password, account.getPasswordHash())) {
            return "Invalid password";

        } else {
            return "Signed in!";
        }
    }
    public int getTotalPrice(){
        return ur.getTotalPrice();
    }
}
