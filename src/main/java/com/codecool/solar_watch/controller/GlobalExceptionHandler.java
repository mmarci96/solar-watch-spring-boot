package com.codecool.solar_watch.controller;

import com.codecool.solar_watch.exception.CityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<String> handleCityNotFound(CityNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex) {
        return ResponseEntity.status(500).body("Something went wrong: " + ex.getMessage());
    }
}
