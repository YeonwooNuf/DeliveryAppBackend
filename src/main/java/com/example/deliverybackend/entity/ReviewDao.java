package com.example.deliverybackend.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class ReviewDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private StoreDao store;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private MenuDao menu;

    @ManyToOne
    @JoinColumn(name = "user_number", nullable = false)
    private UserDao user;

    private double rating;

    @CreationTimestamp
    private LocalDateTime creationTime;

    private String reviewContent;

    // 기본 생성자
    public ReviewDao() {
    }

    // 매개변수 있는 생성자
    public ReviewDao(StoreDao store, MenuDao menu, UserDao user, double rating, LocalDateTime creationTime, String reviewContent) {
        this.store = store;
        this.menu = menu;
        this.user = user;
        this.rating = rating;
        this.creationTime = creationTime;
        this.reviewContent = reviewContent;
    }

    // Getter와 Setter 메서드
    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public StoreDao getStore() {
        return store;
    }

    public void setStore(StoreDao store) {
        this.store = store;
    }

    public MenuDao getMenu() {
        return menu;
    }

    public void setMenu(MenuDao menu) {
        this.menu = menu;
    }

    public UserDao getUser() {
        return user;
    }

    public void setUser(UserDao user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "ReviewDao{" +
                "id=" + reviewId +
                ", store=" + store +
                ", menu=" + menu +
                ", user=" + user +
                ", rating=" + rating +
                ", creationTime=" + creationTime +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}
