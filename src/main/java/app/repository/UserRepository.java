package App.repository;

import App.Model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {
    @Query(value="Select sum(packagePrice) from Packages p inner join UserAccount u on p.packageID = " +
            "u.userId", nativeQuery = true)
    public int getTotalPrice();
    @Query(value = "FROM UserAccount WHERE username = :username")
    public UserAccount getAccount(@Param("username") String username);
}
