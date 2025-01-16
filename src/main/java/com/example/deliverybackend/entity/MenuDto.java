package com.example.deliverybackend.entity;

public class MenuDto {

    private Long productId;

    private Long menu_storeId;

    private String productName;

    private int price;

    private String productImg;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMenu_storeId() {
        return menu_storeId;
    }

    public void setMenu_storeId(Long menu_storeId) {
        this.menu_storeId = menu_storeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }



}
