package com.example.deliverybackend.entity.search;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private int price;

    @Column(nullable = true, length = 255)
    private String productImg;

    @Column(nullable = true, length = 255)
    private String productName;

    @Column(name = "menu_store_id_store_id", nullable = true, insertable = false, updatable = false)
    private Long menuStoreIdStoreId;

    @ManyToOne
    @JoinColumn(name = "menu_store_id_store_id", nullable = true)
    @JsonBackReference
    private Store store;

    // Getter와 Setter
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getMenuStoreIdStoreId() {
        return menuStoreIdStoreId;
    }

    public void setMenuStoreIdStoreId(Long menuStoreIdStoreId) {
        this.menuStoreIdStoreId = menuStoreIdStoreId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
