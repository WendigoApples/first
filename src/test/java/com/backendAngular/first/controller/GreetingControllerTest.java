package com.backendAngular.first.controller;

import com.backendAngular.first.entinty.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @MockBean
    private GreetingController greetingController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreeting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    public void testGreetingWithName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting").param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").value("Hello, Alice!"));
    }
}
