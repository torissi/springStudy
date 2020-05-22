package com.example.restaurant.interfaces;

import com.example.restaurant.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurant")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant restaurant = new Restaurant(1004L, "Bab zip", "Seoul");

        restaurants.add(restaurant);

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bab zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber food", "Seoul"));

        Restaurant restaurant = restaurants.stream() //리스트 중에서
                .filter(r -> r.getId().equals(id)) //r의 아이디가 패스변수의 id와 같은 것을 찾고
                .findFirst() //그 중 첫 번째의
                .get(); //값을 가져와 or .orElse(null); 못찾을 경우 null을 가져와. => 못찾으면 원래는 예외가 발생함
 
        return restaurant;
    }
}
