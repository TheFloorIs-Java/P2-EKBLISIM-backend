package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.AdminAccount;

@Repository
public interface AdminRepository extends JpaRepository<AdminAccount, String> {

}