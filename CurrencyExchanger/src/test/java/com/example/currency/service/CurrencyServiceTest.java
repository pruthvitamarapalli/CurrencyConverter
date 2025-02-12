package com.example.currency.service;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.example.currency.model.CurrencyConverter;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CurrencyServiceTest {
	
	
	private final CurrencyService service = new CurrencyService(new RestTemplate());

    @Test
    void testFetchExchangeRates() {
        Map<String, Double> rates = service.fetchExchangeRates("USD");
        assertNotNull(rates);
        assertTrue(rates.containsKey("EUR"));
    }

    @Test
    void testConvertCurrency() {
        CurrencyConverter request = new CurrencyConverter("USD", "EUR", 100);
        Map<String, Object> response = service.convertCurrency(request);
        assertEquals("USD", response.get("from"));
        assertEquals("EUR", response.get("to"));
        assertNotNull(response.get("convertedAmount"));
    }
}
