package com.coingecko.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PingResponse {
    @SerializedName("gecko_says")
    private String geckoSays;

    @Override
    public String toString() {
        return "PingResponse{" +
                "gecko_says='" + geckoSays + '\'' +
                '}';
    }
}
