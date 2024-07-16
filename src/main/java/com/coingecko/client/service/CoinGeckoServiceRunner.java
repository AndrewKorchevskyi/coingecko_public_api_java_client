package com.coingecko.client.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoinGeckoServiceRunner {
    private final CoinGeckoServiceImpl coinGeckoService;

    public CoinGeckoServiceRunner() {
        coinGeckoService = new CoinGeckoServiceImpl();
    }

    public void executePing() {
        coinGeckoService.ping();
    }

    public void executeGetCoinDetails(String ids) {
        coinGeckoService.getCoinDetails(ids);
    }

    public void terminateService() {
        System.exit(0);
    }
}
