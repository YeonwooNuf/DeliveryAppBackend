package com.example.deliverybackend.entity;

public class StoreRatingDao {
    private Long storeId;
    private double averageRating;

    public StoreRatingDao(Long storeId, double averageRating) {
        this.storeId = storeId;
        this.averageRating = averageRating;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
