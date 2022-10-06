package app.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import app.model.Payment;
import app.service.PaymentService;

import org.junit.jupiter.api.Assertions;

class PaymentControllerUnitTest {
    /*
    @Test
    public void getPayment() {
        Payment payment = new Payment("DOUG", null, "123", "456", "01", "25");
        PaymentService ps = Mockito.mock(PaymentService.class);
        PaymentController pc = new PaymentController(ps);

        Mockito.when(ps.getPayment("DOUG")).thenReturn(payment);

        Assertions.assertEquals(payment, pc.getPayment("DOUG"));
        Mockito.verify(ps).getPayment("DOUG");
    }

    @Test
    public void getPayment() {
        Payment payment = new Payment("DOUG", null, "123", "456", "01", "25");
        PaymentService ps = Mockito.mock(PaymentService.class);
        PaymentController pc = new PaymentController(ps);

        Mockito.when(ps.getPayment("DOUG")).thenReturn(payment);

        Assertions.assertEquals(payment, pc.getPayment("DOUG"));
        Mockito.verify(ps).getPayment("DOUG");
    } */
}