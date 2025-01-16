package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.OrderDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderDao, Long> {
    List<OrderDao> findByUserNumber(Long userNumber);
}