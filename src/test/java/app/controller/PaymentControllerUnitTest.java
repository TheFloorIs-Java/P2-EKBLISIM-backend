package app.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import app.model.Payment;
import app.service.PaymentService;

import org.junit.jupiter.api.Assertions;

class PaymentControllerUnitTest {
    @Test
    public void getPayment() {
        Payment payment = new Payment("PHIL", null, "4485295529430250", "666", "02", "2026");
        PaymentService ps = Mockito.mock(PaymentService.class);
        PaymentController pc = new PaymentController(ps);

        Mockito.when(ps.getPayment("PHIL")).thenReturn(payment);

        Assertions.assertEquals(payment, pc.getPayment("PHIL"));
        Mockito.verify(ps).getPayment("PHIL");
    }

    @Test
    public void updatePayment() {
        Payment payment = new Payment("SETH", null, "4485295529430250", "666", "02", "2026");
        PaymentService ps = Mockito.mock(PaymentService.class);
        PaymentController pc = new PaymentController(ps);

        Mockito.when(ps.updatePayment(payment)).thenReturn("Payment information updated!");

        Assertions.assertEquals("Payment information updated!", pc.updatePayment(payment));
        Mockito.verify(ps).updatePayment(payment);
    }
}