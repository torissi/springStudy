package com.example.restaurant.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RestaurantTests {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L,"Bab zip", "Seoul"); //Bap zip은 가게 주소
        assertThat(restaurant.getId()).isEqualTo(1004L);
        assertThat(restaurant.getName()).isEqualTo("Bab zip");
        assertThat(restaurant.getAddress()).isEqualTo("Seoul");
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant(1004L, "Bab zip", "Seoul");
        assertThat(restaurant.getInformation()).isEqualTo("Bab zip in Seoul");

    }
}

//나는 이거를 어떻게 쓸거야에 초점을 맞추기