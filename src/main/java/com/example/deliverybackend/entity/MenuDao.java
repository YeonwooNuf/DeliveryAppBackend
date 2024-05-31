package com.example.deliverybackend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class MenuDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    // storeId를 외래 키로 사용하여 StoreDao와 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreDao storeId; // StoreDao 객체를 참조하는 필드

    private String productName;
    private int price;
    private String productImg;




    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public StoreDao getStoreId() {
        return storeId;
    }

    public void setStoreId(StoreDao storeId) {
        this.storeId = storeId;
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
