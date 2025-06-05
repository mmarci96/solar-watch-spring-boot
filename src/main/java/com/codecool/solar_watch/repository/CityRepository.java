package com.codecool.solar_watch.repository;

import com.codecool.solar_watch.entity.City;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    public City findByName(String name);
}
