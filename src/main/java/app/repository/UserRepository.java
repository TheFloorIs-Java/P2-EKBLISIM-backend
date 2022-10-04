package App.Repository;

import App.Model.Payment;
import App.Model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserAccount, Integer> {
//    @Query("Select sum(packagePrice) from Packages p inner join UserAccount u on p.packageID = " +
//            "u.userId", nativeQuery = true);
    public int getTotalPrice();

}
