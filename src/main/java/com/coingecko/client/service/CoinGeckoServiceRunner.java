package com.coingecko.client.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CoinGeckoServiceRunner {
    private final CoinGeckoService coinGeckoService;

    public CoinGeckoServiceRunner() {
        coinGeckoService = new CoinGeckoService();
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
