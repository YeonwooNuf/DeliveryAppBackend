package com.example.deliverybackend.controller;

import com.example.deliverybackend.entity.ReviewDto;
import com.example.deliverybackend.entity.StoreRatingDao;
import com.example.deliverybackend.service.ReviewService;
import com.example.deliverybackend.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private StoreService storeService;

    @PostMapping
    public List<ReviewDto> saveReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.saveReview(reviewDto);
    }

    @GetMapping("/store/{storeName}")
    public List<ReviewDto> getReviewsByStoreName(@PathVariable String storeName) {
        return reviewService.findByStoreName(storeName);
    }

    @GetMapping("/user/{userNumber}")
    public List<ReviewDto> getReviewsByUserId(@PathVariable Long userNumber) {
        return reviewService.findByUserId(userNumber);
    }

    // 매장의 평균 별점을 가져오는 메서드
    @GetMapping("/{storeId}/rating")
    public StoreRatingDao getStoreRating(@PathVariable Long storeId) {
        List<ReviewDto> reviews = reviewService.getReviewsByStoreId(storeId);
        double averageRating = reviewService.calculateAverageRating(reviews);
        return new StoreRatingDao(storeId, averageRating);
    }
}
