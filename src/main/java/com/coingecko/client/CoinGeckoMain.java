package com.coingecko.client;

import com.coingecko.client.service.CoinGeckoServiceRunner;

public class CoinGeckoMain {
    public static void main(String[] args) {
        CoinGeckoServiceRunner runner = new CoinGeckoServiceRunner();
        runner.executeGetCoinDetails("bitcoin");
        runner.terminateService();
    }
}
