package com.codecool.solar_watch.service;

import com.codecool.solar_watch.model.SolarResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SolarWatchService {
    private final RestTemplate restTemplate;

    public SolarWatchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SolarResponse getSolarResult(double lat, double lng) {
        var prefix = "https://api.sunrise-sunset.org";
        var url = String.format("%s/json?lat=%.6f&lng=%.6f&formatted=0", prefix, lat, lng);

        SolarResponse response = restTemplate.getForObject(url, SolarResponse.class);
        return response;
    }
}
