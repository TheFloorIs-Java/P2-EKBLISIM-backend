package app.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import app.model.UserAccount;
import app.service.PaymentService;
import app.service.UserService;

import org.junit.jupiter.api.Assertions;

class UserControllerUnitTest {
    @Test
    public void signUp() {
        UserAccount user = new UserAccount("DOUG", null, "DOUG");
        UserService us = Mockito.mock(UserService.class);
        PaymentService ps = Mockito.mock(PaymentService.class);
        UserController uc = new UserController(us, ps);

        Mockito.when(us.addUser("DOUG", "DOUG")).thenReturn("Account created!");

        Assertions.assertEquals("Account created!", uc.signUp(user));
        Mockito.verify(us).addUser(user.getUsername(), user.getPassword());
    }

    @Test
    public void signIn() {
        UserAccount user = new UserAccount("DOUG", null, "DOUG");
        UserService us = Mockito.mock(UserService.class);
        UserController uc = new UserController(us, null);

        Mockito.when(us.validateUser("DOUG", "DOUG")).thenReturn("Signed in!");

        Assertions.assertEquals("Signed in!", uc.signIn(user));
        Mockito.verify(us).validateUser(user.getUsername(), user.getPassword());
    }
}