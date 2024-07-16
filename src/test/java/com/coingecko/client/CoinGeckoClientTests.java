package com.coingecko.client;

import com.coingecko.client.service.CoinGeckoService;
import com.coingecko.client.service.CoinGeckoServiceRunner;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CoinGeckoClientTests {
    @Test
    void testExecutePingCallsPingSuccessfully() {
        CoinGeckoService coinGeckoService = mock(CoinGeckoService.class);
        CoinGeckoServiceRunner runner = new CoinGeckoServiceRunner(coinGeckoService);
        runner.executePing();
        verify(coinGeckoService, times(1)).ping();
    }

    @Test
    void testExecuteGetCoinDetailsCallsGetCoinDetailsWithValidIds() {
        CoinGeckoService coinGeckoService = mock(CoinGeckoService.class);
        CoinGeckoServiceRunner runner = new CoinGeckoServiceRunner(coinGeckoService);
        String validIds = "bitcoin,ethereum";
        runner.executeGetCoinDetails(validIds);
        verify(coinGeckoService, times(1)).getCoinDetails(validIds);
    }
}
