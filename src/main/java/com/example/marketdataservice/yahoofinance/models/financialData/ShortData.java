package com.example.marketdataservice.yahoofinance.models.financialData;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ShortData {
    BigDecimal raw;
    String fmt;
}
