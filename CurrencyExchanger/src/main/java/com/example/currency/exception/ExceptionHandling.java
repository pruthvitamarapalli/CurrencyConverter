package com.example.currency.exception;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
    }

}
