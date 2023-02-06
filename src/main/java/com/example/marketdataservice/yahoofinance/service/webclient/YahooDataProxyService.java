package com.example.marketdataservice.yahoofinance.service.webclient;

import com.example.marketdataservice.yahoofinance.models.quote.YahooQuoteRessource;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;
import reactor.util.function.Tuple2;

@Service
public class YahooDataProxyService {

    public Mono<Tuple2<YahooQuoteRessource, Long>> getYahooQuoteGFProxy() {
        long start = System.currentTimeMillis();
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().proxy(proxy ->
                                proxy.type(ProxyProvider.Proxy.HTTP)
                                        .host("213.238.191.39")
                                        .port(10000)
                        )
                )).build()
                .get()
                .uri("https://query1.finance.yahoo.com/v7/finance/quote?symbols=GC=F")
                .retrieve()
                .bodyToMono(YahooQuoteRessource.class)
                .zipWith(Mono.just(System.currentTimeMillis() - start));
    }

    public Mono<Tuple2<String, Long>> getYahooQuoteListProxy() {
        long start = System.currentTimeMillis();
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().proxy(proxy ->
                                proxy.type(ProxyProvider.Proxy.HTTP)
                                        .host("213.238.191.39")
                                        .port(10000)
                        )
                )).build()
                .get()
                .uri("https://query1.finance.yahoo.com/v7/finance/quote?lang=en-US&region=US&corsDomain=finance.yahoo.com&symbols=ABX.TO,NA.TO,FVI.TO")
                .retrieve()
                .bodyToMono(String.class)
                .zipWith(Mono.just(System.currentTimeMillis() - start));
    }

}
