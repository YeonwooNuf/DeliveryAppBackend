package com.example.deliverybackend.entity;

import com.example.deliverybackend.api.NaverStoreCrawler;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "store")
public class StoreDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String storeName;
    private String storeAddress;
    private String category;
    private String storeImg;

    // StoreDao와 MenuDao 간의 일대다 양방향 관계를 설정
    @OneToMany(mappedBy = "menu_storeId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MenuDao> menus;



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

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(String storeImg) {
        this.storeImg = storeImg;
    }
}
