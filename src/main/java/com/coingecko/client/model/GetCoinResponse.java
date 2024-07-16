package com.coingecko.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GetCoinResponse {
    private Map<String, CoinData> coins;

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class CoinData {
        private double usd;
        @SerializedName("usd_market_cap")
        private Double usdMarketCap;
        @SerializedName("usd_24h_vol")
        private Double usd24hVol;
        @SerializedName("usd_24h_change")
        private Double usd24hChange;
        @SerializedName("last_updated_at")
        private Long lastUpdatedAt;
    }
}
