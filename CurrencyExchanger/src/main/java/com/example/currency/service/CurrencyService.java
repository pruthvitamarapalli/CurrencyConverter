package com.example.currency.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.currency.model.CurrencyConverter;

@Service
public class CurrencyService {
	
	private final RestTemplate restTemplate;
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Double> fetchExchangeRates(String base) {
    	String url = API_URL + base;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        
        Map<String, Object> rawRates = (Map<String, Object>) response.get("rates"); // Raw response
        Map<String, Double> exchangeRates = new HashMap<>();

        for (Map.Entry<String, Object> entry : rawRates.entrySet()) {
            exchangeRates.put(entry.getKey(), ((Number) entry.getValue()).doubleValue()); // Convert to Double
        }

        return exchangeRates;
    }

    public Map<String, Object> convertCurrency(CurrencyConverter request) {
        Map<String, Double> rates = fetchExchangeRates(request.getFrom());
        double rate = rates.getOrDefault(request.getTo(), 0.0);
        double convertedAmount = request.getAmount() * rate;

        Map<String, Object> response = new HashMap<>();
        response.put("from", request.getFrom());
        response.put("to", request.getTo());
        response.put("amount", request.getAmount());
        response.put("convertedAmount", convertedAmount);

        return response;
    }

}
