package com.example.restaurant.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

    List<MenuItem> findAllByRestaurantId(Long restautantId);
}

/*
CrudRepository<MenuItem, Long>
* spring-data-jpa는 impl을 구현하지 않고
* jpa와 연결하여 사용할 수 있음
* */
