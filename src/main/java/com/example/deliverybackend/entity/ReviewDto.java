package com.example.deliverybackend.entity;

import java.time.LocalDateTime;


public class ReviewDto {

    // Getter와 Setter 메서드
    private Long reviewId;
    private String storeName;
    private String productNames;
    private Long userNumber;
    private double rating;
    private LocalDateTime creationTime;
    private String reviewContent;



    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductName(String productNames) {
        this.productNames = productNames;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }



    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    // 기본 생성자
    public ReviewDto() {
    }

    // 매개변수 있는 생성자
    public ReviewDto(Long reviewId, String storeName, String productNames, Long userNumber, double rating, LocalDateTime creationTime, String reviewContent) {
        this.reviewId = reviewId;
        this.storeName = storeName;
        this.productNames = productNames;
        this.userNumber = userNumber;
        this.rating = rating;
        this.creationTime = creationTime;
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "reviewId=" + reviewId +
                "storeName=" + storeName +
                ", productNames=" + productNames +
                ", userId=" + userNumber +
                ", rating=" + rating +
                ", creationTime=" + creationTime +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}
