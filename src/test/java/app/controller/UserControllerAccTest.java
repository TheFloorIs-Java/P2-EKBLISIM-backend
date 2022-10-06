package app.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import app.model.UserAccount;
import app.util.ObjToJSON;

@AutoConfigureMockMvc
public class UserControllerAccTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void signUp() {
        UserAccount ua = new UserAccount("DOUG", null, "DOUG");
        String uaJSON = ObjToJSON.JSONify(ua);

        RequestBuilder request = MockMvcRequestBuilders.post("/users")
            .content(uaJSON)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Account created!")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void signIn() {
        UserAccount ua = new UserAccount("DOUG", null, "DOUG");
        String uaJSON = ObjToJSON.JSONify(ua);

        RequestBuilder request = MockMvcRequestBuilders.post("/users")
            .content(uaJSON)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON);

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Signed in!")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAccount() {
        RequestBuilder request = MockMvcRequestBuilders.post("/users/DOUG");

        try {
            mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}