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

import app.model.UserAccount;
import app.util.ObjToJSON;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerAccTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void signUp() {
        UserAccount user = new UserAccount("CHAD", null, "CHAD");
        String uaJSON = ObjToJSON.JSONify(user);

        RequestBuilder request = MockMvcRequestBuilders.post("/users")
            .content(uaJSON)
            .contentType(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Account created!"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void signUpWithSpace() {
        UserAccount user = new UserAccount("DO G", null, "DOUG");
        String uaJSON = ObjToJSON.JSONify(user);

        RequestBuilder request = MockMvcRequestBuilders.post("/users")
            .content(uaJSON)
            .contentType(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Username must not include spaces"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void signIn() {
        UserAccount user = new UserAccount("BILL", null, "BILL");
        String userJSON = ObjToJSON.JSONify(user);

        RequestBuilder signUpRequest = MockMvcRequestBuilders.post("/users")
            .content(userJSON)
            .contentType(MediaType.APPLICATION_JSON);

        RequestBuilder signInRequest = MockMvcRequestBuilders.post("/users/BILL")
            .content(userJSON)
            .contentType(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(signUpRequest);
            mvc.perform(signInRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Signed in!"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void signInInvalidPassword() {
        UserAccount user = new UserAccount("DANTE", null, "DANTE");
        String userJSON = ObjToJSON.JSONify(user);

        RequestBuilder signUpRequest = MockMvcRequestBuilders.post("/users")
            .content(userJSON)
            .contentType(MediaType.APPLICATION_JSON);

        user.setPassword("DOUGIE");
        userJSON = ObjToJSON.JSONify(user);

        RequestBuilder signInRequest = MockMvcRequestBuilders.post("/users/DANTE")
            .content(userJSON)
            .contentType(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(signUpRequest);
            mvc.perform(signInRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Invalid password"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}