package com.example.restaurant.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();

    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);
}

/*
* Optional
* - java8부터 추가된 타입
* - null을 처리하지 않고, Restaurant이 있냐 없냐로 직접 구분할 수 있도록 만든 타입
* - null로 접근했을 때 생기는 문제에 대해 처리할 수 있음
*
* */
