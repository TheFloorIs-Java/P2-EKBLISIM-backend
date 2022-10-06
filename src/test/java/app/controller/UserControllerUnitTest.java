package app.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import app.model.UserAccount;
import app.service.UserService;

import org.junit.jupiter.api.Assertions;

class UserControllerUnitTest {
    @Test
    public void signUp() {
        UserAccount ua = new UserAccount("DOUG", null, "DOUG");
        UserService us = Mockito.mock(UserService.class);
        UserController uc = new UserController(us, null);

        Mockito.when(us.addUser("DOUG", "DOUG")).thenReturn("Account created!");

        Assertions.assertEquals("Account created!", uc.signUp(ua));
        Mockito.verify(us).addUser(ua.getUsername(), ua.getPassword());
    }

    @Test
    public void signIn() {
        UserAccount ua = new UserAccount("DOUG", null, "DOUG");
        UserService us = Mockito.mock(UserService.class);
        UserController uc = new UserController(us, null);

        Mockito.when(us.validateUser("DOUG", "DOUG")).thenReturn("Signed in!");

        Assertions.assertEquals("Signed in!", uc.signIn(ua));
        Mockito.verify(us).validateUser(ua.getUsername(), ua.getPassword());
    }

    @Test
    public void getAccount() {
        UserAccount ua = new UserAccount("DOUG", null, "DOUG");
        UserService us = Mockito.mock(UserService.class);
        UserController uc = new UserController(us, null);

        Mockito.when(us.getAccount("DOUG")).thenReturn(ua);

        Assertions.assertEquals(ua, uc.getAccount("DOUG"));
        Mockito.verify(us).getAccount("DOUG");
    }
}