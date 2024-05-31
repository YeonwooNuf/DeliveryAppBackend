package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.StoreDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreDao, Long> {
    StoreDao findByStoreName(String storeName);
}