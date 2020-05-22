package com.example.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private List<Restaurant> restaurants = new ArrayList<>(); //중복되어 들어가니 차라리 필드로 선언
    
    public RestaurantRepository() { //생성자로 데이터 주입
        restaurants.add(new Restaurant(1004L, "Bab zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber food", "Seoul")); 
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream() //리스트 중에서
                .filter(r -> r.getId().equals(id)) //r의 아이디가 패스변수의 id와 같은 것을 찾고
                .findFirst() //그 중 첫 번째의
                .get(); //값을 가져와 or .orElse(null); 못찾을 경우 null을 가져와. => 못찾으면 원래는 예외가 발생함
    }
}
