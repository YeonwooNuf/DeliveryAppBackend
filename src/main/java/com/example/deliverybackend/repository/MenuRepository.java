package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.MenuDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuDao, Long> {
    MenuDao findByProductName(String productName);
}
