package com.example.restaurant.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    @Test
    public void creation() {
        User user = User.builder()
                .email("tester@exaple.com")
                .name("tester")
                .level(100L)
                .build();

        assertThat(user.getName()).isEqualTo("tester");
        assertThat(user.isAdmin()).isEqualTo(true);
        assertThat(user.isActive()).isEqualTo(true);

        user.deactivate();

        assertThat(user.isActive()).isEqualTo(false);
    }

    @Test
    public void reraurantOwner() {
        User user = User.builder().level(1L).build();

        assertThat(user.isRestaurantOwner()).isEqualTo(false);

        user.setRestaurantId(1004L);

        assertThat(user.isRestaurantOwner()).isEqualTo(true);
        assertThat(user.getRestaurantId()).isEqualTo(1004L);
    }

}