package com.coingecko.client.service;

import com.coingecko.client.model.GetCoinResponse;
import com.coingecko.client.model.PingResponse;
import com.coingecko.client.retrofit.RetrofitClient;
import com.coingecko.client.util.Config;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.Map;

@Slf4j
public class CoinGeckoServiceImpl {
    private final CoinGeckoService coinGeckoService;
    private final String apiKey;

    public CoinGeckoServiceImpl() {
        Retrofit retrofit = RetrofitClient.getClient();
        coinGeckoService = retrofit.create(CoinGeckoService.class);
        this.apiKey = Config.get("api_key");
    }

    @SneakyThrows
    public void ping() {
        Call<PingResponse> call = coinGeckoService.ping(apiKey);
        var response = call.execute();
        log.info("Response: {}", response.body());
    }

    @SneakyThrows
    public void getCoinDetails(String ids) {
        Call<Map<String, GetCoinResponse.CoinData>> call = coinGeckoService.getCoinDetails(apiKey, ids, "usd", true, true, true, true, "full");
        var response = call.execute();
        log.info("Response: {}", response.body());
    }
}