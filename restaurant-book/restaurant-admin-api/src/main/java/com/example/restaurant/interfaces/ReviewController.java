package com.example.restaurant.interfaces;

import com.example.restaurant.application.ReviewService;
import com.example.restaurant.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list() {
        List<Review> reviews = reviewService.getReviews();

        return reviews;
    }

}
