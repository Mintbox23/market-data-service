package com.example.marketdataservice.yahoofinance.service;

import com.example.marketdataservice.yahoofinance.service.runnable.ABXRunnable;
import com.example.marketdataservice.yahoofinance.service.runnable.GFRunnable;
import com.example.marketdataservice.yahoofinance.service.runnable.NARunnable;
import com.example.marketdataservice.yahoofinance.service.runnable.TNXRunnable;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class SchedulerService {

    private final ABXRunnable abxRunnable;
    private final NARunnable naRunnable;
    private final GFRunnable gfRunnable;
    private final TNXRunnable tnxRunnable;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private final int DELAY = 1000;
    private final int INITIAL_DELAY = 1000;

    public SchedulerService(ABXRunnable abxRunnable, NARunnable naRunnable, GFRunnable gfRunnable, TNXRunnable tnxRunnable) {
        this.abxRunnable = abxRunnable;
        this.naRunnable = naRunnable;
        this.gfRunnable = gfRunnable;
        this.tnxRunnable = tnxRunnable;
    }

    public void startSchedulerABX() {
        this.scheduledExecutorService.scheduleWithFixedDelay(abxRunnable, INITIAL_DELAY, DELAY, TimeUnit.MILLISECONDS);
    }

    public void startSchedulerNA() {
        this.scheduledExecutorService.scheduleWithFixedDelay(naRunnable, INITIAL_DELAY, DELAY, TimeUnit.MILLISECONDS);
    }

    public void startSchedulerGF() {
        this.scheduledExecutorService.scheduleWithFixedDelay(gfRunnable, INITIAL_DELAY, DELAY, TimeUnit.MILLISECONDS);
    }

    public void startSchedulerTNX() {
        this.scheduledExecutorService.scheduleWithFixedDelay(tnxRunnable, INITIAL_DELAY, DELAY, TimeUnit.MILLISECONDS);
    }

}
