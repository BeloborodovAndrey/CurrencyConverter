package de.c24.finacc.klt.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.c24.finacc.klt.web.model.RateDto;
import de.c24.finacc.klt.web.service.RatesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ConvertController.class)
class ConvertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RatesServiceImpl ratesServiceImpl;

    @Test
    void convert() throws Exception {
        RateDto rateDto = new RateDto("{USD:60000}", "ARM", "USD", "100");
                mockMvc.perform(post("/api/convert")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(rateDto)))
                .andExpect(status().isOk());
    }
}