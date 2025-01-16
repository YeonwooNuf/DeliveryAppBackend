package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.FavoriteDao;
import com.example.deliverybackend.entity.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<FavoriteDao, FavoriteId> {
    void deleteByFavoriteUserNumberAndFavoriteStoreId (Long userNumber, Long storeId);

    List<FavoriteDao> findByFavoriteUserNumber(Long userNumber);


}
