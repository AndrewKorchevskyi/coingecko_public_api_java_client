package com.coingecko.client.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoinGeckoServiceManager implements CoinGeckoCallback {
    private final CoinGeckoServiceImpl coinGeckoService;

    public CoinGeckoServiceManager() {
        coinGeckoService = new CoinGeckoServiceImpl();
    }

    public void executePing() {
        coinGeckoService.pingAsync(this);
    }

    @Override
    public void onPingSuccess(String message) {
        log.info("Ping success: {}", message);
        terminate();
    }

    @Override
    public void onPingFailure(String message) {
        log.info("Ping failure: {}", message);
        terminate();
    }

    private void terminate() {
        System.exit(0);
    }
}
