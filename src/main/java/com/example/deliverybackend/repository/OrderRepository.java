package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.OrderDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDao, Long> {
    // 추가적인 주문 히스토리 관련 메서드가 필요하다면 여기에 추가할 수 있습니다.
}