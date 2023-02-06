package com.example.marketdataservice.yahoofinance.service.webclient;

import com.example.marketdataservice.yahoofinance.models.defaultKeyStatistics.YahooDefaultKeyStatisticsRessource;
import com.example.marketdataservice.yahoofinance.models.options.YahooOptionsRessource;
import com.example.marketdataservice.yahoofinance.models.quote.YahooQuoteRessource;
import com.example.marketdataservice.yahoofinance.models.financialData.YahooFinancialDataRessource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class YahooDataService {

    public Mono<Tuple2<YahooFinancialDataRessource, Long>> getYahooQuoteABX() {
        long start = System.currentTimeMillis();
        return WebClient.builder().build()
                .get()
                .uri("https://query1.finance.yahoo.com/v11/finance/quoteSummary/?symbol=abx.to&modules=financialData")
                .retrieve()
                .bodyToMono(YahooFinancialDataRessource.class)
                .zipWith(Mono.just(System.currentTimeMillis() - start));
    }

    public Mono<YahooFinancialDataRessource> getYahooQuoteNA() {
        return WebClient.builder().build()
                .get()
                .uri("https://query1.finance.yahoo.com/v11/finance/quoteSummary/?symbol=na.to&modules=financialData")
                .retrieve()
                .bodyToMono(YahooFinancialDataRessource.class);
    }

    public Mono<Tuple2<YahooQuoteRessource, Long>> getYahooQuoteGF() {
        long start = System.currentTimeMillis();
        return WebClient.builder().build()
                .get()
                .uri("https://query1.finance.yahoo.com/v7/finance/quote?symbols=GC=F")
                .retrieve()
                .bodyToMono(YahooQuoteRessource.class)
                .zipWith(Mono.just(System.currentTimeMillis() - start));
    }

    public Mono<Tuple2<YahooQuoteRessource, Long>> getYahooQuoteTNX() {
        long start = System.currentTimeMillis();
        return WebClient.builder().build()
                .get()
                .uri("https://query1.finance.yahoo.com/v7/finance/quote?symbols=GC=F")
                .retrieve()
                .bodyToMono(YahooQuoteRessource.class)
                .zipWith(Mono.just(System.currentTimeMillis() - start));
    }

    public Mono<Tuple2<YahooQuoteRessource, Long>> getYahooQuoteList() {
        long start = System.currentTimeMillis();
        return WebClient.builder().build()
                .get()
                .uri("https://query1.finance.yahoo.com/v7/finance/quote?lang=en-US&region=US&corsDomain=finance.yahoo.com&symbols=ASX.AX,ABX:TO,GOOG,AMZN,AAPL")
                .retrieve()
                .bodyToMono(YahooQuoteRessource.class)
                .zipWith(Mono.just(System.currentTimeMillis() - start));
    }

    public Mono<YahooDefaultKeyStatisticsRessource> getYahooStatisticsABX() {
        return WebClient.builder().build()
                .get()
                .uri("https://query1.finance.yahoo.com/v11/finance/quoteSummary/?symbol=abx.to&modules=defaultKeyStatistics")
                .retrieve()
                .bodyToMono(YahooDefaultKeyStatisticsRessource.class);
    }

    public Mono<YahooOptionsRessource> getYahooOptionsABX() {
        return WebClient.builder().build()
                .get()
                .uri("https://query1.finance.yahoo.com/v7/finance/options/ABX.TO")
                .retrieve()
                .bodyToMono(YahooOptionsRessource.class);
    }

    public Mono<YahooFinancialDataRessource> getYahooQuoteASX() {
        return WebClient.builder().build()
                .get()
                .uri("https://query1.finance.yahoo.com/v11/finance/quoteSummary/?symbol=asx.ax&modules=financialData")
                .retrieve()
                .bodyToMono(YahooFinancialDataRessource.class);
    }

}