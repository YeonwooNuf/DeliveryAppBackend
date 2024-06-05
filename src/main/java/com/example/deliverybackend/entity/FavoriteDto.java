package com.example.deliverybackend.entity;



public class FavoriteDto {
    private Long favoriteUserNumber;

    private Long favoriteStoreId;

    private String favorite_storeImg;

    private String favoriteStoreName;

    public String getFavoriteStoreName() {
        return favoriteStoreName;
    }

    public void setFavoriteStoreName(String favoriteStoreName) {
        this.favoriteStoreName = favoriteStoreName;
    }

    private double rating;

//    public FavoriteDto(Long favorite_userNumber, Long favorite_storeId, String favorite_storeImg, double rating) {
//        this.favorite_userNumber = favorite_userNumber;
//        this.favorite_storeId = favorite_storeId;
//        this.favorite_storeImg = favorite_storeImg;
//        this.rating = rating;
//    }


    public Long getFavoriteUserNumber() {
        return favoriteUserNumber;
    }

    public void setFavoriteUserNumber(Long favoriteUserNumber) {
        this.favoriteUserNumber = favoriteUserNumber;
    }

    public Long getFavoriteStoreId() {
        return favoriteStoreId;
    }

    public void setFavoriteStoreId(Long favoriteStoreId) {
        this.favoriteStoreId = favoriteStoreId;
    }

    public String getFavorite_storeImg() {
        return favorite_storeImg;
    }

    public void setFavorite_storeImg(String favorite_storeImg) {
        this.favorite_storeImg = favorite_storeImg;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}


