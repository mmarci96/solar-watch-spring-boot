package com.codecool.solar_watch.utils;

public class StringUtils {
    public static String capitalizeFirstChar(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
