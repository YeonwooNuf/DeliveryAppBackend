package com.example.deliverybackend.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "menu")
public class MenuDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    // storeId를 외래 키로 사용하여 StoreDao와 연결
    @ManyToOne(fetch = FetchType.LAZY)
    private StoreDao menu_storeId; // StoreDao 객체를 참조하는 필드

    private String productName;
    private int price;
    private String productImg;






    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public StoreDao getMenu_storeId() {
        return menu_storeId;
    }

    public void setMenu_storeId(StoreDao menu_storeId) {
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




    //LAZY로딩으로 인한 json 반환 오류 때문에 DAO에서 DTO 객체로 옮겨 담아서 전송
    //DTO에 담는 메서드
    public MenuDto toDto() {
        MenuDto menuDto = new MenuDto();
        menuDto.setProductId((this.getProductId()));
        menuDto.setProductName(this.getProductName());
        menuDto.setPrice(this.getPrice());
        menuDto.setProductImg(this.getProductImg());
        menuDto.setMenu_storeId(this.getMenu_storeId().getStoreId()); // StoreId만 가져오거나 필요에 따라 수정

        return menuDto;
    }
}
