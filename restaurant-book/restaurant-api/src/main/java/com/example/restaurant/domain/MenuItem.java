package com.example.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue // 자동으로 id 할당
    private Long id;

    private Long restaurantId;

    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MenuItem() { }
}
