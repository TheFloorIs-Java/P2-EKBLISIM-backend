package app.service;

import java.time.LocalDate;

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
    public void addPayment(Payment payment) {
        this.pr.save(payment);
    }

    public Payment getPayment(String username) {
        //this.logger.info("Payment information retrieved");
        return this.pr.findById(username).get();
    }

    // Input-checking here could probably be done in the front-end, but here it is just in case
    @Transactional
    public String updatePayment(Payment payment) {
        LocalDate now = LocalDate.now();
        Boolean validExpiration = Integer.parseInt(payment.getExpirationYear()) > now.getYear()
            || (Integer.parseInt(payment.getExpirationYear()) == now.getYear() && Integer.parseInt(payment.getExpirationMonth()) >= now.getMonthValue());
        String cardNumber = payment.getCardNumber();
        Boolean validCardNumber = Luhn.validate(cardNumber);

        if (cardNumber.length() != 16) {
            //this.logger.error("Invalid card number");
            return "Invalid card number";
            
        } else if (payment.getCVV().length() != 3) {
            //this.logger.error("Invalid security code");
            return "Invalid security code";

        } else if (!validExpiration) {
            //this.logger.error("Invalid expiration date");
            return "Invalid expiration date";

        } else if (!validCardNumber) {
            //this.logger.error("Invalid card number");
            return "Invalid card number";
            
        } else {
            this.pr.save(payment);

            //this.logger.error("Payment information updated");
            return "Payment information updated!";
        }
    }
}