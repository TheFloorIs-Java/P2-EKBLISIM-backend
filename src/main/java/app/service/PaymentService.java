package App.service;

import App.Model.Payment;
import App.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    PaymentRepository pr;
    @Autowired
    public PaymentService(PaymentRepository pr){
        this.pr = pr;
    }
    public Payment addPayment(Payment p){
        return pr.save(p);
    }

}
