package com.example.marketdataservice.yahoofinance.service;

import com.example.marketdataservice.yahoofinance.service.webclient.YahooDataService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AlgoService {

    private final YahooDataService yahooDataService;

    private BigDecimal sellPrice = BigDecimal.valueOf(24.24);

    public AlgoService(YahooDataService yahooDataService) {
        this.yahooDataService = yahooDataService;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void addStockQuote() {
        yahooDataService.getYahooQuoteABX().subscribe(yahooStockRessource -> {
            BigDecimal quote = yahooStockRessource.getT1().getQuoteSummary().getResult().get(0).getFinancialData().getCurrentPrice().getRaw();
            if (quote.compareTo(sellPrice) == -1) {

            }
        });
    }

    public void displayGFQuote() {
        yahooDataService.getYahooQuoteGF().subscribe(yahooFuturesRessource -> {
            System.out.println("Gold Futures : " + yahooFuturesRessource.getT1().getQuoteResponse().getResult().get(0).getRegularMarketPrice());
        });
    }

    /*public void displayTNXQuote() {
        yahooDataService.
    }*/



}
