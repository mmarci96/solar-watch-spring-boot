package com.codecool.solar_watch.controller;

import com.codecool.solar_watch.model.SolarResponse;
import com.codecool.solar_watch.service.GeocodingService;
import com.codecool.solar_watch.service.SolarWatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolarWatchController {
    private final GeocodingService geocodingService;
    private final SolarWatchService solarWatchService;

    @Autowired
    public SolarWatchController(
            GeocodingService geocodingService, SolarWatchService solarWatchService) {
        this.geocodingService = geocodingService;
        this.solarWatchService = solarWatchService;
    }

    @GetMapping("/watch/{city}")
    public ResponseEntity<SolarResponse> getSunsetByCity(@PathVariable String city) {
        var location = geocodingService.getLocationByCityName(city);
        if (location == null) {
            return ResponseEntity.status(404).build();
        }
        System.out.println(location);
        SolarResponse res = solarWatchService.getSolarResult(location.lat(), location.lon());
        return ResponseEntity.ok(res);
    }
}
