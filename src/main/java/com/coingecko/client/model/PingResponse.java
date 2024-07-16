package com.coingecko.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PingResponse {
    @SerializedName("gecko_says")
    private String geckoSays;
}
