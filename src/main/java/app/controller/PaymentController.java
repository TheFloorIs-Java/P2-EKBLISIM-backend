package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.aspect.Logging;
import app.model.Payment;
import app.service.PaymentService;

@RestController
@CrossOrigin
public class PaymentController {
    private PaymentService ps;

    @Autowired
    public PaymentController(PaymentService ps) {
        this.ps = ps;
    }

    @PostMapping("payments")
    public String addPayment(@RequestBody Payment payment) {
        Logging.LOG.info("Updating payment information");
        return this.ps.addPayment(payment);
    }

    @GetMapping("payments/{username}")
    public Payment getPayment(@PathVariable("username") String username) {
        Logging.LOG.info("Retrieving payment information");
        return this.ps.getPayment(username);
    }

    @PutMapping("payments/{username}")
    public String updatePayment(@RequestBody Payment payment) {
        Logging.LOG.info("Updating payment information");
        return this.ps.updatePayment(payment);
    }
}