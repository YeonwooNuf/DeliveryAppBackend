package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.FavoriteDao;
import com.example.deliverybackend.entity.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<FavoriteDao, FavoriteId> {
}
