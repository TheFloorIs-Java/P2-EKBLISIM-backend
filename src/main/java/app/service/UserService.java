package App.service;

import App.Model.UserAccount;
import App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    UserRepository ur;
    @Autowired
    public UserService(UserRepository ur){
        this.ur = ur;
    }
    @Transactional
    public String addUser(String username, String password) {
        Optional<UserAccount> optional = this.ur.findById(username);

        if (optional != null) {
            return "An account with that username already exists";

        }  else if (username.contains(" ")) {
            return "Username must not include spaces";

        } else if (username.equals("")) {
            return "Username must not be empty";

        } else {
            UserAccount account = new UserAccount(username, Hash.SHA384toString(password), null);
            this.ur.save(account);
            return "Account created!";
        }
    }
    public List<UserAccount> getUsers(){
        return ur.findAll();
    }
    public String validateUser(String username, String password) {
        Optional<UserAccount> optional = this.ur.findById(username);

        if (optional == null) {
            return "No account with that username exists";

        } else if (!Hash.SHA384toString(password).equals(optional.get().getPasswordHash())) {
            return "Invalid password";

        } else {
            return "Signed in!";
        }
    }

}
