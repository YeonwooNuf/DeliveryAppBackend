package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.StoreDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<StoreDao, Long> {
    StoreDao findByStoreName(String storeName);

    @Query("SELECT AVG(r.rating) FROM ReviewDao r WHERE r.store = :store")
    Double findAverageRatingByStore(StoreDao store);
}