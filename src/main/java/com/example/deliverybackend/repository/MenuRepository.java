package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.MenuDao;
import com.example.deliverybackend.entity.StoreDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuDao, Long> {
}
