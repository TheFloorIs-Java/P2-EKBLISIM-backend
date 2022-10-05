package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.model.AdminAccount;

public interface AdminRepository extends JpaRepository<AdminAccount, String> {
    @Query(value = "FROM AdminAccount WHERE adminname = :adminname")
    public AdminAccount getAdmin(@Param("adminname") String adminname);
}