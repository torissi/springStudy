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

    @NotBlank(message = "이름 넣어라")
    private String name;

    @NotNull
    private Integer score;

    @NotBlank(message = "ㅅㅁ 넣어라")
    private String description;
}
