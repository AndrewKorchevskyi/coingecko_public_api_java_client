package com.coingecko.client.service;

public interface CoinGeckoCallback {
    void onPingSuccess(String message);
    void onPingFailure(String message);
}
