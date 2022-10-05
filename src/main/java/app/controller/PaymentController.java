package App.controller;

import App.Model.Payment;
import App.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PaymentController {
    PaymentService ps;
    @Autowired
    public PaymentController(PaymentService ps){
        this.ps = ps;
    }
    @PostMapping("payments")
    public Payment addPayment(@RequestBody Payment p){
        return ps.addPayment(p);
    }
}
