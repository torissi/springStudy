package com.example.restaurant;

import com.example.restaurant.domain.Review;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class ObjectMapperTest {



    @Test
    public void test() throws JsonProcessingException {
         Review build = Review.builder()
                .description("d")
                .id(1L)
                .name("a")
                .score(4)
                .build();


        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(build);
        System.out.println(s);

        Review review = objectMapper.readValue(s, Review.class);
        System.out.println(review.toString());
    }

}
