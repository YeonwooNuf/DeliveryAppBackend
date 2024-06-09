package com.example.deliverybackend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="orderhistory")
public class OrderDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long storeId;
    private String storeName;
    private Long userNumber;
    private String productNames; // JSON 형태로 저장 혹은 String List로 변환하여 사용 가능
    private Integer totalPrice;
    @CreationTimestamp
    private LocalDateTime orderTime;

    public OrderDao() {
        // 기본 생성자
    }

    public OrderDao(Long orderId, Long storeId, String storeName, Long userNumber, String productNames, Integer totalPrice, LocalDateTime orderTime) {
        this.orderId = orderId;
        this.storeId = storeId;
        this.storeName = storeName;
        this.userNumber = userNumber;
        this.productNames = productNames;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

}
