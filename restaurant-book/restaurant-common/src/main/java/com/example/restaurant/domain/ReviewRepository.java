package com.example.restaurant.domain;

import com.example.restaurant.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAll();

    List<Review> findAllByRestaurantId(Long restaurantId);

    Review save(Review review);
}
