package com.example.restaurant.interfaces;

import com.example.restaurant.application.ReviewService;
import com.example.restaurant.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> create() throws URISyntaxException {
        Review review = Review.builder().build();

        reviewService.addReview(review);
        return ResponseEntity.created(new URI("/restaurants/1/reviews/1"))
                .body("{}");
    }
}