package com.example.deliverybackend.entity;

import java.io.Serializable;
import java.util.Objects;

public class FavoriteId implements Serializable {
    private Long favoriteUserNumber;
    private Long favoriteStoreId;

    // 기본 생성자
    public FavoriteId() {}

    // 매개변수 있는 생성자
    public FavoriteId(Long favoriteUserNumber, Long favoriteStoreId) {
        this.favoriteUserNumber = favoriteUserNumber;
        this.favoriteStoreId = favoriteStoreId;
    }

    // hashCode와 equals 메서드 오버라이딩
    @Override
    public int hashCode() {
        return Objects.hash(favoriteUserNumber, favoriteStoreId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FavoriteId that = (FavoriteId) obj;
        return Objects.equals(favoriteUserNumber, that.favoriteUserNumber) &&
                Objects.equals(favoriteStoreId, that.favoriteStoreId);
    }

    // Getters and Setters

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
}
