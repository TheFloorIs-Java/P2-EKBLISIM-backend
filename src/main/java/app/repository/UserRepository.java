package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, String> {

}