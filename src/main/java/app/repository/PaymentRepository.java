package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {
    
}