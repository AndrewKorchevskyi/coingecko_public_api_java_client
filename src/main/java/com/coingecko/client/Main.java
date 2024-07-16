package com.coingecko.client;

import com.coingecko.client.service.CoinGeckoServiceManager;

public class Main {
    public static void main(String[] args) {
        CoinGeckoServiceManager manager = new CoinGeckoServiceManager();
        manager.executePing();
    }
}
