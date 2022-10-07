package app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import app.model.Payment;
import app.util.ObjToJSON;

@AutoConfigureMockMvc
@SpringBootTest
public class PaymentControllerAccTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getPayment() {
        Payment payment = new Payment("PETE", null, "4485295529430250", "666", "02", "2026");
        String paymentJSON = ObjToJSON.JSONify(payment);

        RequestBuilder addPaymentRequest = MockMvcRequestBuilders.post("/payments")
            .content(paymentJSON)
            .contentType(MediaType.APPLICATION_JSON);

        RequestBuilder getPaymentRequest = MockMvcRequestBuilders.get("/payments/PETE");

        try {
            mvc.perform(addPaymentRequest);
            mvc.perform(getPaymentRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(paymentJSON));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePayment() {
        Payment payment = new Payment("DAMON", null, "4485295529430250", "666", "02", "2026");
        String paymentJSON = ObjToJSON.JSONify(payment);

        RequestBuilder addPaymentRequest = MockMvcRequestBuilders.post("/payments")
            .content(paymentJSON)
            .contentType(MediaType.APPLICATION_JSON);

        Payment updatePayment = new Payment("DAMON", null, "4485295529430250", "999", "02", "2026");
        String updatePaymentJSON = ObjToJSON.JSONify(updatePayment);

        RequestBuilder updatePaymentRequest = MockMvcRequestBuilders.put("/payments/DAMON")
            .content(updatePaymentJSON)
            .contentType(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(addPaymentRequest);
            mvc.perform(updatePaymentRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Payment information updated!"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePaymentWithWrongCardNumber() {
        Payment payment = new Payment("BEN", null, "4485295529430250", "666", "02", "2026");
        String paymentJSON = ObjToJSON.JSONify(payment);

        RequestBuilder addPaymentRequest = MockMvcRequestBuilders.post("/payments")
            .content(paymentJSON)
            .contentType(MediaType.APPLICATION_JSON);

        Payment updatePayment = new Payment("BEN", null, "1111111111111111", "666", "02", "2026");
        String updatePaymentJSON = ObjToJSON.JSONify(updatePayment);

        RequestBuilder updatePaymentRequest = MockMvcRequestBuilders.put("/payments/BEN")
            .content(updatePaymentJSON)
            .contentType(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(addPaymentRequest);
            mvc.perform(updatePaymentRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Invalid card number"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}