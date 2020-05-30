package com.example.restaurant.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RestaurantTests {

    @Test
    public void creation() {
          //builder pattern // 아래의 정보를 삽입하고 빌드를 하자
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bab zip")
                .address("Seoul")
                .build();

                assertThat(restaurant.getId()).isEqualTo(1004L);
        assertThat(restaurant.getName()).isEqualTo("Bab zip");
        assertThat(restaurant.getAddress()).isEqualTo("Seoul");
    }

    @Test
    public void information() {
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bab zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getInformation()).isEqualTo("Bab zip in Seoul");

    }
}

//나는 이거를 어떻게 쓸거야에 초점을 맞추기