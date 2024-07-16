package com.coingecko.client.service;

import com.coingecko.client.model.PingResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinGeckoService {
    @GET("ping")
    Call<PingResponse> ping(@Query("x_cg_demo_api_key") String apiKey);
}
