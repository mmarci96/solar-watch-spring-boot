package com.codecool.solar_watch.model;

public record Results(
        String sunrise,
        String sunset,
        String solar_noon,
        int day_length,
        String civil_twilight_begin,
        String civil_twilight_end,
        String nautical_twilight_begin,
        String nautical_twilight_end,
        String astronomical_twilight_begin,
        String astronomical_twilight_end) {}
