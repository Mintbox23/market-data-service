package com.example.marketdataservice.yahoofinance.models.options;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Quote {
    String language;
    String region;
    String quoteType;
    String typeDisp;
    String quoteSourceName;
    boolean triggerable;
    String customPriceAlertConfidence;
    String headSymbolAsString;
    boolean contractSymbol;
    BigDecimal firstTradeDateMilliseconds;
    BigDecimal priceHint;
    BigDecimal regularMarketDayHigh;
    String regularMarketDayRange;
    BigDecimal regularMarketDayLow;
    BigDecimal regularMarketVolume;
    BigDecimal regularMarketPreviousClose;
    BigDecimal bid;
    BigDecimal ask;
    BigDecimal bidSize;
    BigDecimal askSize;
    String fullExchangeName;
    BigDecimal regularMarketOpen;
    BigDecimal averageDailyVolume3Month;
    BigDecimal averageDailyVolume10Day;
    BigDecimal fiftyTwoWeekLowChange;
    BigDecimal fiftyTwoWeekLowChangePercent;
    String fiftyTwoWeekRange;
    BigDecimal fiftyTwoWeekHighChange;
    BigDecimal fiftyTwoWeekHighChangePercent;
    BigDecimal fiftyTwoWeekLow;
    BigDecimal fiftyTwoWeekHigh;
    BigDecimal openInterest;
    BigDecimal expireDate;
    String expireIsoDate;
    BigDecimal fiftyDayAverage;
    BigDecimal fiftyDayAverageChange;
    BigDecimal fiftyDayAverageChangePercent;
    BigDecimal twoHundredDayAverage;
    BigDecimal twoHundredDayAverageChange;
    BigDecimal twoHundredDayAverageChangePercent;
    BigDecimal sourceInterval;
    BigDecimal exchangeDataDelayedBy;
    boolean tradeable;
    boolean cryptoTradeable;
    String currency;
    String exchangeTimezoneName;
    String exchangeTimezoneShortName;
    BigDecimal gmtOffSetMilliseconds;
    String market;
    boolean esgPopulated;
    BigDecimal regularMarketChangePercent;
    BigDecimal regularMarketPrice;
    BigDecimal regularMarketChange;
    BigDecimal regularMarketTime;
    String marketState;
    String underlyingSymbol;
    String underlyingExchangeSymbol;
    String exchange;
    String shortName;
    String symbol;
}
