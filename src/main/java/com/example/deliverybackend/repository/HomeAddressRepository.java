package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.HomeAddressDao;
//import com.example.deliverybackend.entity.HomeAddressId;
import com.example.deliverybackend.entity.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeAddressRepository extends JpaRepository<HomeAddressDao, Long> {
    List<HomeAddressDao> findByAddressUserNumber(UserDao user);
}
