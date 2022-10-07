package app.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import app.model.Payment;
import app.service.PaymentService;
import app.util.ObjToJSON;

@WebMvcTest(PaymentController.class)
public class PaymentControllerIntTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private PaymentService ps;

    @Test
    public void getPayment() {
        Payment payment = new Payment("DONNIE", null, "4485295529430250", "666", "02", "2026");
        String paymentJSON = ObjToJSON.JSONify(payment);

        Mockito.when(ps.getPayment("DONNIE")).thenReturn(payment);

        RequestBuilder request = MockMvcRequestBuilders.get("/payments/DONNIE");

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(paymentJSON));
            Mockito.verify(this.ps).getPayment("DONNIE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePayment() {
        Payment payment = new Payment("KEITH", null, "4485295529430250", "666", "02", "2026");
        String paymentJSON = ObjToJSON.JSONify(payment);

        Mockito.when(ps.updatePayment(payment)).thenReturn("Payment information updated!");

        RequestBuilder request = MockMvcRequestBuilders.put("/payments/KEITH")
            .content(paymentJSON)
            .contentType(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Payment information updated!"));
            Mockito.verify(this.ps).updatePayment(payment);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}