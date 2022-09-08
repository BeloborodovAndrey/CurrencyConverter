package de.c24.finacc.klt.web.util;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

/**
 * util class which helps with converting operations
 */
@UtilityClass
public class RatesUtils {

    private static final Map<String, String> RANDOM_RATES_DATA = Map.ofEntries(
            entry("AED", "3.651573"),
            entry("AFN", "89.721034"),
            entry("ALL", "118.253063"),
            entry("AMD", "402.537416"),
            entry("ANG", "1.792281"),
            entry("AOA", "426.623107"),
            entry("ARS", "139.961571"),
            entry("AUD", "1.47764"),
            entry("AWG", "1.794422"),
            entry("AZN", "1.688504"),
            entry("BAM", "1.965259"),
            entry("BBD", "2.008024"),
            entry("BDT", "94.504402"),
            entry("BGN", "1.953985"),
            entry("BHD", "0.374745"),
            entry("BIF", "2035.997793"),
            entry("BMD", "0.99414"),
            entry("BND", "1.400849"),
            entry("BOB", "6.872178"),
            entry("BRL", "5.217444")
    );

    private static final List<String> RATES = RANDOM_RATES_DATA.keySet().stream().toList();

    /**
     * Converting input string to map
     * @param rates string from ui with rates and amounts
     * @return map with rates and amount
     */
    public static Map<String, String> convert(String rates, String baseCurrency) {
        if (rates.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, String> ratesMap = new HashMap<>();
        try {
            String[] keyValuePairs = rates.substring(1, rates.length() - 1).replaceAll("\"", "").replaceAll(baseCurrency, "").split(",");

            for (String pair : keyValuePairs) {
                String[] entry = pair.split(":");
                ratesMap.put(entry[0].trim(), entry[1].trim());
            }
            return ratesMap;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new HashMap<>();
        }
    }

    public static Map<String, String> generateTestData() {
        return RANDOM_RATES_DATA;
    }

    public static List<String> generateTestRates() {
        return RATES;
    }
}
