package de.c24.finacc.klt.web.controller;

import de.c24.finacc.klt.web.model.RateDto;
import de.c24.finacc.klt.web.service.RatesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contoller for rates requests
 */
@RestController
@RequestMapping("api")
@AllArgsConstructor
public class ConvertController {

    private RatesService ratesServiceImpl;

    @PostMapping(value = "/convert")
    public ResponseEntity<String> convert(@RequestBody RateDto dto) {
        return new ResponseEntity<>(ratesServiceImpl.convert(dto), HttpStatus.OK);
    }
}
