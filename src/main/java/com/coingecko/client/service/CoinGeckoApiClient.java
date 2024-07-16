package com.coingecko.client.service;

import com.coingecko.client.model.GetCoinResponse;
import com.coingecko.client.model.PingResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.Map;

public interface CoinGeckoApiClient {
    @GET("ping")
    Call<PingResponse> ping(@Header("x_cg_demo_api_key") String apiKey);

    @GET("simple/price")
    Call<Map<String, GetCoinResponse.CoinData>> getCoinDetails(
            @Header("x-cg-demo-api-key") String apiKey,
            @Query("ids") String ids,
            @Query("vs_currencies") String vsCurrencies,
            @Query("include_market_cap") Boolean includeMarketCap,
            @Query("include_24hr_vol") Boolean include24hrVol,
            @Query("include_24hr_change") Boolean include24hrChange,
            @Query("include_last_updated_at") Boolean includeLastUpdatedAt,
            @Query("precision") String precision
    );
}
