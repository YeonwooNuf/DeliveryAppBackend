package com.example.deliverybackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite")
@IdClass(FavoriteId.class)
public class FavoriteDao {

    @Id
    private Long favoriteUserNumber;

    @Id
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

    // Getters and Setters

    @Transient
    private UserDao userDao;

    @Transient
    private StoreDao storeDao;

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

    @PostLoad
    private void postLoad() {
        // 필요 시 데이터 로딩 시점에 객체로 변환하는 로직 추가
    }

    // 직접 객체로 변환
    public void loadUserAndStore(UserDao userDao, StoreDao storeDao) {
        this.userDao = userDao;
        this.storeDao = storeDao;
    }
}
