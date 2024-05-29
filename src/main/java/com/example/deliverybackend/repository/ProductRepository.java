package com.example.deliverybackend.repository;

import com.example.deliverybackend.model.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDao, Long> {
}
