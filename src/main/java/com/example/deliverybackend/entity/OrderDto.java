package com.example.deliverybackend.entity;

public class OrderDto {

    private Long storeId;
    private String storeName;
    private Long userNumber;
    private String productNames;
    private int totalPrice;

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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    // 예를 들어 생성자는 다음과 같이 정의할 수 있습니다.
    public OrderDto(Long storeId, String storeName, Long userNumber, String productNames, int totalPrice) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.userNumber = userNumber;
        this.productNames = productNames;
        this.totalPrice = totalPrice;
    }
}
