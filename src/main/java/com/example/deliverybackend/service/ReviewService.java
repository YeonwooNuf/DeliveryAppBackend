package com.example.deliverybackend.service;

import com.example.deliverybackend.entity.*;
import com.example.deliverybackend.repository.MenuRepository;
import com.example.deliverybackend.repository.ReviewRepository;
import com.example.deliverybackend.repository.StoreRepository;
import com.example.deliverybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private StoreService storeService;

    public List<ReviewDto> saveReview(ReviewDto reviewDto) {

        System.out.println("Received ReviewDto: " + reviewDto);

        // 필수 필드가 null이 아닌지 확인
        if (reviewDto.getStoreName() == null) {
            throw new IllegalArgumentException("Store name must not be null");
        }
        if (reviewDto.getProductNames() == null) {
            throw new IllegalArgumentException("Product names must not be null");
        }
        if (reviewDto.getUserNumber() == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }

        // Store 조회
        StoreDao store = storeRepository.findByStoreName(reviewDto.getStoreName());
        if (store == null) {
            throw new IllegalArgumentException("Store not found: " + reviewDto.getStoreName());
        }

        // User 조회
        UserDao user = userRepository.findById(reviewDto.getUserNumber())
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + reviewDto.getUserNumber()));

        // Product names를 쉼표로 분리
        String[] productNames = reviewDto.getProductNames().split(",");
        List<ReviewDto> savedReviews = new ArrayList<>();

        for (String productName : productNames) {
            productName = productName.trim(); // 공백 제거

            // Menu 조회
            MenuDao menu = menuRepository.findByProductName(productName);
            if (menu == null) {
                throw new IllegalArgumentException("Product not found: " + productName);
            }

            // Review 객체 생성 및 저장
            ReviewDao reviewDao = new ReviewDao();
            reviewDao.setStore(store);
            reviewDao.setMenu(menu);
            reviewDao.setUser(user);
            reviewDao.setRating(reviewDto.getRating());
            reviewDao.setCreationTime(reviewDto.getCreationTime());
            reviewDao.setReviewContent(reviewDto.getReviewContent());

            ReviewDao savedReview = reviewRepository.save(reviewDao);

            // 저장된 리뷰를 ReviewDto로 변환하여 리스트에 추가
            savedReviews.add(new ReviewDto(
                    savedReview.getReviewId(),
                    savedReview.getStore().getStoreName(),
                    savedReview.getMenu().getProductName(),
                    savedReview.getUser().getUserNumber(),
                    savedReview.getRating(),
                    savedReview.getCreationTime(),
                    savedReview.getReviewContent()
            ));
        }

        return savedReviews;
    }

    public List<ReviewDto> findByStoreName(String storeName) {
        StoreDao store = storeRepository.findByStoreName(storeName);
        if (store == null) {
            throw new IllegalArgumentException("Store not found: " + storeName);
        }

        List<ReviewDao> reviews = reviewRepository.findByStore(store);
        return reviews.stream().map(review -> new ReviewDto(
                review.getReviewId(),
                review.getStore().getStoreName(),
                review.getMenu().getProductName(),
                review.getUser().getUserNumber(),
                review.getRating(),
                review.getCreationTime(),
                review.getReviewContent()
        )).collect(Collectors.toList());
    }

    public List<ReviewDto> findByUserId(Long userNumber) {
        UserDao user = userRepository.findById(userNumber)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userNumber));

        List<ReviewDao> reviews = reviewRepository.findByUser(user);
        return reviews.stream().map(review -> new ReviewDto(
                review.getReviewId(),
                review.getStore().getStoreName(),
                review.getMenu().getProductName(),
                review.getUser().getUserNumber(),
                review.getRating(),
                review.getCreationTime(),
                review.getReviewContent()
        )).collect(Collectors.toList());
    }

    public Double calculateAverageRating(List<ReviewDto> reviews) {
        if (reviews.isEmpty()) {
            return 0.0; // 리뷰가 없는 경우 평균 별점을 0으로 설정
        }

        double totalRating = 0.0;
        for (ReviewDto review : reviews) {
            totalRating += review.getRating();
        }

        return totalRating / reviews.size();
    }

    public List<ReviewDto> getReviewsByStoreId(Long storeId) {
        StoreDao store = storeService.getStoreById(storeId);
        if (store == null) {
            throw new IllegalArgumentException("Store not found: " + storeId);
        }

        List<ReviewDao> reviewDaos = reviewRepository.findByStore(store);
        List<ReviewDto> reviewDtos = new ArrayList<>();

        for (ReviewDao reviewDao : reviewDaos) {
            ReviewDto reviewDto = new ReviewDto();
            // ReviewDao에서 ReviewDto로 필요한 정보 복사
            reviewDto.setReviewId(reviewDao.getReviewId());
            reviewDto.setStoreName(reviewDao.getStore().getStoreName());
            reviewDto.setProductName(reviewDao.getMenu().getProductName());
            reviewDto.setUserNumber(reviewDao.getUser().getUserNumber());
            reviewDto.setRating(reviewDao.getRating());
            reviewDto.setCreationTime(reviewDao.getCreationTime());
            reviewDto.setReviewContent(reviewDao.getReviewContent());

            reviewDtos.add(reviewDto);
        }

        return reviewDtos;
    }
}
