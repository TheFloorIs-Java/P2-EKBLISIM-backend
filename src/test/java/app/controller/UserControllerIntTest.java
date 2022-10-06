package app.controller;

import org.hamcrest.Matchers;
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

import app.model.UserAccount;
import app.service.PaymentService;
import app.service.UserService;
import app.util.ObjToJSON;

@WebMvcTest(UserController.class)
public class UserControllerIntTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService us;
    @MockBean
    private PaymentService ps;

    @Test
    public void signUp() {
        UserAccount ua = new UserAccount("DOUG", null, "DOUG");
        String uaJSON = ObjToJSON.JSONify(ua);

        Mockito.when(us.addUser("DOUG", "DOUG")).thenReturn("Account created!");

        RequestBuilder request = MockMvcRequestBuilders.post("/users")
            .content(uaJSON)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Account created!")));
            Mockito.verify(this.us).addUser(ua.getUsername(), ua.getPassword());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void signIn() {
        UserAccount ua = new UserAccount("DOUG", null, "DOUG");
        String uaJSON = ObjToJSON.JSONify(ua);

        Mockito.when(us.validateUser("DOUG", "DOUG")).thenReturn("Signed in!");

        RequestBuilder request = MockMvcRequestBuilders.post("/users")
            .content(uaJSON)
            .contentType(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Signed in!")));
            Mockito.verify(this.us).validateUser(ua.getUsername(), ua.getPassword());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAccount() {
        UserAccount ua = new UserAccount("DOUG", null, "DOUG");

        Mockito.when(us.getAccount("DOUG")).thenReturn(ua);

        RequestBuilder request = MockMvcRequestBuilders.get("/users/DOUG");

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
            Mockito.verify(this.us).getAccount("DOUG");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}