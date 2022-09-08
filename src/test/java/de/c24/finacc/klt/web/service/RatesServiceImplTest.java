package de.c24.finacc.klt.web.service;

import de.c24.finacc.klt.web.model.RateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RatesServiceImplTest {

    @Autowired
    private RatesServiceImpl ratesServiceImpl;

    @Test
    void convert_test() {
        RateDto rateDto = new RateDto("{\"ARMUSD:345\", \"ARMEUR:400\", \"ARMAMD:60000\", \"ARMARS:7000\"}", "ARM", "USD", "100");
        String actualRes = ratesServiceImpl.convert(rateDto);

        assertNotNull(actualRes);
        assertEquals("34500", actualRes);
    }

    @Test
    void convertWithParseError_test() {
        RateDto rateDto = new RateDto("{\"ARMUSD:3d45\", \"ARMEUR:400\", \"ARMAMD:60000\", \"ARMARS:7000\"}", "ARM", "USD", "100");
        String actualRes = ratesServiceImpl.convert(rateDto);

        assertNotNull(actualRes);
        assertEquals("parsing error", actualRes);
    }

    @Test
    void convertWithNumberFormatError_test() {
        RateDto rateDto = new RateDto("{\"ARMUSD:3.4.5\", \"ARMEUR:400\", \"ARMAMD:60000\", \"ARMARS:7000\"}", "ARM", "USD", "100");
        String actualRes = ratesServiceImpl.convert(rateDto);

        assertNotNull(actualRes);
        assertEquals("parsing error", actualRes);
    }

    @Test
    void convertWithMatchesCurrecies_test() {
        RateDto rateDto = new RateDto("{\"USDEUR:400\", \"USDAMD:60000\", \"USDARS:7000\"}", "USD", "USD", "100");
        String actualRes = ratesServiceImpl.convert(rateDto);

        assertNotNull(actualRes);
        assertEquals("100", actualRes);
    }
}