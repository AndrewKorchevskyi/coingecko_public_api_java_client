package com.coingecko.client.service;

import com.coingecko.client.model.GetCoinResponse;
import com.coingecko.client.model.PingResponse;
import com.coingecko.client.util.retrofit.RetrofitClient;
import com.coingecko.client.util.config.ConfigLoader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class CoinGeckoService {
    private final CoinGeckoApiClient coinGeckoApiClient;
    private final String apiKey;

    public CoinGeckoService() {
        Retrofit retrofit = RetrofitClient.getClient();
        coinGeckoApiClient = retrofit.create(CoinGeckoApiClient.class);
        this.apiKey = ConfigLoader.get("api_key");
    }

    @SneakyThrows(IOException.class)
    public void ping() {
        Call<PingResponse> call = coinGeckoApiClient.ping(apiKey);
        var response = call.execute();
        log.info("Successfully called Ping endpoint. Response: {}", response.body());
    }

    @SneakyThrows(IOException.class)
    public void getCoinDetails(String ids) {
        Call<Map<String, GetCoinResponse.CoinData>> call = coinGeckoApiClient.getCoinDetails(apiKey, ids, "usd", true, true, true, true, "full");
        var response = call.execute();
        log.info("Successfully Called Coin Details endpoint for {} coin(s). Response: {}", ids, response.body());
    }
}