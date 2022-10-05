package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, String> {
    @Query(value = "FROM UserAccount WHERE username = :username")
    public UserAccount getAccount(@Param("username") String username);
}