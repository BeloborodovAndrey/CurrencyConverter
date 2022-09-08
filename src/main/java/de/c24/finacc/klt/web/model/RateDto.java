package de.c24.finacc.klt.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RateDto {
    private String ratesData;
    private String baseCurrency;
    private String targetCurrency;
    private String amount;
}
