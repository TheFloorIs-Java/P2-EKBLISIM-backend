package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {
    
    @Query(value = "FROM Payment WHERE username = :username")
    public Payment getPayment(@Param("username") String username);
}