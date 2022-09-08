package de.c24.finacc.klt.rest;

import de.c24.finacc.klt.web.util.RatesUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Rest Service
 */
@RestController
@RequestMapping("/api")
public class RestService {

    /**
     * Test rest endpoint
     *
     * @return Map of key/values
     */
    @GetMapping("/testData")
    public ResponseEntity<Map<String, String>> test() {
        Map<String, String> response = RatesUtils.generateTestData();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * If we can't receive server data
     * @return list of Rates
     */
    @GetMapping("/testRates")
    public ResponseEntity<List<String>> testRates() {
        List<String> response = RatesUtils.generateTestRates();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
