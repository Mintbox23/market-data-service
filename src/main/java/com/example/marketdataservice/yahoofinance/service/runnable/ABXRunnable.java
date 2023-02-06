package com.example.marketdataservice.yahoofinance.service.runnable;

import com.example.marketdataservice.yahoofinance.service.AlgoService;
import org.springframework.stereotype.Component;

@Component
public class ABXRunnable implements Runnable {

    private final AlgoService algoService;

    public ABXRunnable(AlgoService algoService) {
        this.algoService = algoService;
    }

    @Override
    public void run() {
        algoService.addStockQuote();
    }

}
