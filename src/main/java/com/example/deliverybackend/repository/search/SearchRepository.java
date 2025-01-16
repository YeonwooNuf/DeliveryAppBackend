package com.example.deliverybackend.repository.search;

import com.example.deliverybackend.entity.search.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Menu, Long> {
    @Query("SELECT m FROM Menu m JOIN m.store s WHERE m.productName LIKE %:keyword% OR s.storeName LIKE %:keyword%")
    List<Menu> searchByKeyword(@Param("keyword") String keyword);
}
