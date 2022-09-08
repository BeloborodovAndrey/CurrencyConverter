package de.c24.finacc.klt.web.service;

import de.c24.finacc.klt.web.model.RateDto;
import de.c24.finacc.klt.web.util.RatesUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * @author Andrey
 * service for conferting rates
 */
@Service
@AllArgsConstructor
@Slf4j
public class RatesServiceImpl implements RatesService {

    /**
     * conversation currency
     * @param dto with rates data
     * @return String with amount value
     */
    @Override
    public String convert(RateDto dto) {
        log.info("starting convert");
        try {
            Map<String, String> ratesMap = RatesUtils.convert(dto.getRatesData(), dto.getBaseCurrency());

            if (ratesMap.containsKey(dto.getTargetCurrency())) {
                try {
                    BigDecimal targetCurrencyValue = new BigDecimal(ratesMap.get(dto.getTargetCurrency()));
                    BigDecimal amountRate = new BigDecimal(dto.getAmount());
                    return String.valueOf(targetCurrencyValue.multiply(amountRate).setScale(2, RoundingMode.HALF_UP));
                } catch (ClassCastException | NumberFormatException e) {
                    log.error("problems with rates converting: {}", e.getMessage());
                    return "parsing error";
                }
                //in this case currencies matches
            } else {
                return dto.getAmount();
            }
        } catch (Exception ex) {
            log.error("problems with rates converting: {}", ex.getMessage());
        }
        return "";
    }
}
