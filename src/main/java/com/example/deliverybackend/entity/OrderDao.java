package com.example.deliverybackend.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orderhistory")
public class OrderDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long storeId;
    private String storeName;
    private Long userNumber;
    private String productNames;
    private Timestamp orderTime;
    private int totalPrice;

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

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderDao() {
        // 기본 생성자 내용은 비워둡니다.
    }

    public OrderDao(Long storeId, String storeName, Long userNumber, String productNames, int totalPrice) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.userNumber = userNumber;
        this.productNames = productNames;
        this.totalPrice = totalPrice;
    }

}
