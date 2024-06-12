package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.ReviewDao;
import com.example.deliverybackend.entity.StoreDao;
import com.example.deliverybackend.entity.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDao, Long> {
    List<ReviewDao> findByStore(StoreDao store);
    List<ReviewDao> findByUser(UserDao user);
}
