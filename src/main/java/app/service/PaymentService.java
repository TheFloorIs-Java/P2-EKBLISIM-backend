package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.Payment;
import app.repository.PaymentRepository;

@Service
public class PaymentService {
    private PaymentRepository pr;

    @Autowired
    public PaymentService(PaymentRepository pr) {
        this.pr = pr;
    }

    @Transactional
    public void updatePayment(Payment payment) {
        this.pr.save(payment);
    }

    public Payment getPayment(String username) {
        return this.pr.getPayment(username);
    }
}