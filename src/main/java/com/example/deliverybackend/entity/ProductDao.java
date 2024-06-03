//package com.example.deliverybackend.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "products")
//@NoArgsConstructor
//@AllArgsConstructor
//public class ProductDao {
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private MenuDao productId;
//
//    @Column(name = "product_name")
//    private String productName;
//
//    @Column(name = "qty")
//    private int qty;
//
//    @Column(name = "price")
//    private int price;
//
//    public MenuDao getProductId() {
//        return productId;
//    }
//
//    public void setProductId(MenuDao productId) {
//        this.productId = productId;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public int getQty() {
//        return qty;
//    }
//
//    public void setQty(int qty) {
//        this.qty = qty;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//}
