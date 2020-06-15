package com.example.restaurant.domain;

import com.example.restaurant.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Review save(Review review);
}
