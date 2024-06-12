package com.example.deliverybackend.repository;

import com.example.deliverybackend.entity.HomeAddressDao;
//import com.example.deliverybackend.entity.HomeAddressId;
import com.example.deliverybackend.entity.UserDao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HomeAddressRepository extends JpaRepository<HomeAddressDao, Long> {
    List<HomeAddressDao> findByAddressUserNumber(UserDao user);

    @Modifying
    @Transactional
    @Query("DELETE FROM HomeAddressDao h WHERE h.addressUserNumber = :user AND h.HomeAddressNumber = :addressId")
    void deleteByAddressUserNumberAndAddress(@Param("user") UserDao addressUserNumber, @Param("addressId") Long addressId);
}
