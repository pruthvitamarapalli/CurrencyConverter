package com.example.currency.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency.model.CurrencyConverter;
import com.example.currency.service.CurrencyService;

@RestController
@RequestMapping("/api")
public class CurrencyController {
	
	 private final CurrencyService service;

	    public CurrencyController(CurrencyService service) {
	        this.service = service;
	    }

	    @GetMapping("/rates")
	    public Map<String, Double> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
	        return service.fetchExchangeRates(base);
	    }

	    @PostMapping("/convert")
	    public Map<String, Object> convertCurrency(@RequestBody CurrencyConverter request) {
	        return service.convertCurrency(request);
	    }

}
