package com.example.marketdataservice.yahoofinance.models.options;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result {
    String underlyingSymbol;
    Quote quote;
}
