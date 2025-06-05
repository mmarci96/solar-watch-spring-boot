package com.codecool.solar_watch.service;

import com.codecool.solar_watch.entity.City;
import com.codecool.solar_watch.exception.CityNotFoundException;
import com.codecool.solar_watch.model.Location;
import com.codecool.solar_watch.repository.CityRepository;
import com.codecool.solar_watch.utils.StringUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class GeocodingService {
    @Value("${spring.geocoding.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final CityRepository cityRepository;

    public GeocodingService(RestTemplate restTemplate, CityRepository cityRepository) {
        this.restTemplate = restTemplate;
        this.cityRepository = cityRepository;
    }

    public Location getLocationByCityName(String name) {
        var cityName = StringUtils.capitalizeFirstChar(name);
        var existing = cityRepository.findByName(cityName);
        if (existing != null) {
            System.out.println("City exists: " + existing);
            return new Location(
                    existing.getZip(),
                    existing.getName(),
                    existing.getLatitude(),
                    existing.getLongitude(),
                    existing.getCountry());
        }
        var prefix = "http://api.openweathermap.org/geo/1.0";
        String url = String.format("%s/direct?q=%s&appid=%s", prefix, cityName, apiKey);
        try {
            var locations = Arrays.asList(restTemplate.getForObject(url, Location[].class));
            if (locations.size() > 0) {
                var location = locations.get(0);
                var createCity = new City();
                createCity.setZip(location.zip());
                createCity.setName(location.name());
                createCity.setLatitude(location.lat());
                createCity.setLongitude(location.lon());
                createCity.setCountry(location.country());
                cityRepository.save(createCity);
                System.out.println("City created: " + createCity);
            }
            return locations.get(0);
        } catch (Exception e) {
            throw new CityNotFoundException(cityName);
        }
    }
}
