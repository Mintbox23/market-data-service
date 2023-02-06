package com.example.marketdataservice.yahoofinance.models.financialData;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class FinancialData {
    BigDecimal maxAge;
    ShortData currentPrice;
    ShortData targetHighPrice;
    ShortData targetLowPrice;
    ShortData targetMeanPrice;
    ShortData targetMedianPrice;
    ShortData recommendationMean;
    String recommendationKey;
    LongData numberOfAnalystOpinions;
    LongData totalCash;
    ShortData totalCashPerShare;
    LongData ebitda;
    LongData totalDebt;
    ShortData quickRatio;
    ShortData currentRatio;
    LongData totalRevenue;
    ShortData debtToEquity;
    ShortData revenuePerShare;
    ShortData returnOnAssets;
    ShortData returnOnEquity;
    LongData grossProfits;
    LongData freeCashflow;
    LongData operatingCashflow;
    ShortData earningsGrowth;
    ShortData revenueGrowth;
    ShortData grossMargins;
    ShortData ebitdaMargins;
    ShortData operatingMargins;
    ShortData profitMargins;
    String financialCurrency;
}
