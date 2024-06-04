package com.example.deliverybackend.entity;

import java.io.Serializable;
import java.util.Objects;

//즐겨찾기 테이블 기본키 복합키로 정의하는 클래스
public class FavoriteId implements Serializable {
    private Long favorite_userId;
    private Long favorite_storeId;

    public FavoriteId() {}

    public FavoriteId(Long favorite_userId, Long favorite_storeId) {
        this.favorite_userId = favorite_userId;
        this.favorite_storeId = favorite_storeId;
    }

    // Getters and Setters
    public Long getFavorite_userId() {
        return favorite_userId;
    }

    public void setFavorite_userId(Long favorite_userId) {
        this.favorite_userId = favorite_userId;
    }

    public Long getFavorite_storeId() {
        return favorite_storeId;
    }

    public void setFavorite_storeId(Long favorite_storeId) {
        this.favorite_storeId = favorite_storeId;
    }

    // hashCode and equals methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 같은 객체인 경우
        if (o == null || getClass() != o.getClass()) return false; // null이거나 클래스가 다른 경우
        FavoriteId that = (FavoriteId) o; // 캐스팅
        return Objects.equals(favorite_userId, that.favorite_userId) && Objects.equals(favorite_storeId, that.favorite_storeId); // 필드 값 비교
    }


    @Override
    public int hashCode() {
        return Objects.hash(favorite_userId, favorite_storeId);
    }
}
