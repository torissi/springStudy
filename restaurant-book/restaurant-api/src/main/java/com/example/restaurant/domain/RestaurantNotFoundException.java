package com.example.restaurant.domain;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(Long id) {
        super("Could not Find Restaurant " + id);
    }
}
