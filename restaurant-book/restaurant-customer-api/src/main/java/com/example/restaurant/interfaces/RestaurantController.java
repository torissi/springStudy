package com.example.restaurant.interfaces;

import com.example.restaurant.application.RestaurantService;
import com.example.restaurant.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService; //service로만 처리할것이기 때문에 repository 주입한 것 다 삭제

    @GetMapping("/restaurant")
    public List<Restaurant> list(@RequestParam("region") String region,
                                 @RequestParam("categoryId") Long categoryId) {
        List<Restaurant> restaurants = restaurantService.getRestaurants(region, categoryId);

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id); //가게 기본 정보 + 메뉴 정보 한 번에 가져오고 싶음

        return restaurant;
    }

}
