package com.example.restaurant.interfaces;

import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    //private RestaurantRepository reopsitory = new RestaurantRepository(); //직접 객체를 만들지 않고
    @Autowired //이 어노테이션을 사용하여 컨트롤러가 만들어 질떄 스프링이 자동으로 리파지토리를 넣어줌
    private RestaurantRepository reopsitory;

    @GetMapping("/restaurant")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = reopsitory.findAll();

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = reopsitory.findById(id);

        return restaurant;
    }
}

// 레파지토리를 이용하여 컨트롤러가 간단해짐
// ui 레이어는 사용자와 내부에 있는 비즈니스로직(도메인로직)이 서로 상관 없고 징검다리 역할만하고 
// 실제 비즈니스 로직은 도메인 레이어에서 함