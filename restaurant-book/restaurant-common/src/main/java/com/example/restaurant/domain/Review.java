package com.example.restaurant.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;
    
    private String name;

    @NotNull
    private Integer score;

    @NotBlank(message = "설명필요")
    private String description;

    public Long getRestaurantId() {
        return restaurantId;
    }
}
