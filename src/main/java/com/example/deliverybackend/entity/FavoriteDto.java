package com.example.deliverybackend.entity;



public class FavoriteDto {
    private UserDao favorite_userId;

    private StoreDao favorite_storeId;

    private String favorite_storeImg;
    private float rating;

    public UserDao getFavorite_userId() {
        return favorite_userId;
    }

    public void setFavorite_userId(UserDao favorite_userId) {
        this.favorite_userId = favorite_userId;
    }

    public StoreDao getFavorite_storeId() {
        return favorite_storeId;
    }

    public void setFavorite_storeId(StoreDao favorite_storeId) {
        this.favorite_storeId = favorite_storeId;
    }

    public String getFavorite_storeImg() {
        return favorite_storeImg;
    }

    public void setFavorite_storeImg(String favorite_storeImg) {
        this.favorite_storeImg = favorite_storeImg;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
