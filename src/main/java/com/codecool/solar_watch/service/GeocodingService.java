package com.codecool.solar_watch.service;

import com.codecool.solar_watch.exception.CityNotFoundException;
import com.codecool.solar_watch.model.Location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class GeocodingService {
    @Value("${spring.geocoding.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GeocodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Location getLocationByCityName(String city) {
        var prefix = "http://api.openweathermap.org/geo/1.0";
        String url = String.format("%s/direct?q=%s&appid=%s", prefix, city, apiKey);
        try {
            var locations = Arrays.asList(restTemplate.getForObject(url, Location[].class));
            return locations.get(0);
        } catch (Exception e) {
            throw new CityNotFoundException(city);
        }
    }
}
