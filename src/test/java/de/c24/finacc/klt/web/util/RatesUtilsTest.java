package de.c24.finacc.klt.web.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;


class RatesUtilsTest {

    @Test
    void convert() {
        String rates = "{\"ARMUSD:345\", \"ARMEUR:400\", \"ARMAMD:60000\", \"ARMARS:7000\"}";
        Map<String, String> expectedMap = RatesUtils.convert(rates, "ARM");

        Assertions.assertNotNull(expectedMap);
        Assertions.assertEquals(4, expectedMap.size());
    }

    @Test
    void convertIncorrectData_test() {
        String rates = "{\"ARMUSD:34da5\", \"ARMEUR:400\"\"ARMEUR:400\"\"ARMAMD:60000\", \"ARMARS:7000\"}";
        Map<String, String> expectedMap = RatesUtils.convert(rates, "ARM");

        Assertions.assertNotNull(expectedMap);
        Assertions.assertEquals(3, expectedMap.size());
    }

    @Test
    void convertError_test() {
        String rates = "\'ARMUSD34da5\', \'ARMEUR223\"\"ARMEUR400\"\"ARMAMD:60000\", \"ARMARS:7000\"}";
        Map<String, String> expectedMap = RatesUtils.convert(rates, "ARM");

        Assertions.assertNotNull(expectedMap);
        Assertions.assertEquals(0, expectedMap.size());
    }
}