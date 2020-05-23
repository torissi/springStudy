package com.example.restaurant.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //스프링이 직접 관리할 수 있도록 설정
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();
    
    public RestaurantRepositoryImpl() { //생성자로 데이터 주입
        restaurants.add(new Restaurant(1004L, "Bab zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber food", "Seoul")); 
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurants;
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
