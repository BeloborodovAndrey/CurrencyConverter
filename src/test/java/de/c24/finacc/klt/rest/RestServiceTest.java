package de.c24.finacc.klt.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RestService.class)
class RestServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        mockMvc.perform(get("/api/testData")
                        .contentType("application/json"))
                .andExpect(status().isOk());

    }

    @Test
    void testRates() throws Exception {
        mockMvc.perform(get("/api/testRates")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }
}