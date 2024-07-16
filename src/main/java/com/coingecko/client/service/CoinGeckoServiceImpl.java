package com.coingecko.client.service;

import com.coingecko.client.model.PingResponse;
import com.coingecko.client.retrofit.RetrofitClient;
import com.coingecko.client.util.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CoinGeckoServiceImpl {
    private final CoinGeckoService coinGeckoService;
    private final String apiKey;

    public CoinGeckoServiceImpl() {
        Retrofit retrofit = RetrofitClient.getClient();
        coinGeckoService = retrofit.create(CoinGeckoService.class);
        this.apiKey = Config.get("api_key");
    }

    public void pingAsync(CoinGeckoCallback callback) {
        Call<PingResponse> call = coinGeckoService.ping(apiKey);
        call.enqueue(new Callback<PingResponse>() {
            @Override
            public void onResponse(Call<PingResponse> call, Response<PingResponse> response) {
                if (response.isSuccessful()) {
                    PingResponse pingResponse = response.body();
                    callback.onPingSuccess(pingResponse.toString());
                } else {
                    callback.onPingFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<PingResponse> call, Throwable t) {
                callback.onPingFailure(t.getMessage());
            }
        });
    }
}