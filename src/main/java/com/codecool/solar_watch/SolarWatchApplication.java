package com.codecool.solar_watch;

import com.codecool.solar_watch.utils.DotenvLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolarWatchApplication {

    public static void main(String[] args) {
        DotenvLoader.loadEnv();
        SpringApplication.run(SolarWatchApplication.class, args);
    }
}
