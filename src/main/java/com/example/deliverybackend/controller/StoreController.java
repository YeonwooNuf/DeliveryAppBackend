package com.example.deliverybackend.controller;


import com.example.deliverybackend.entity.StoreDao;
import com.example.deliverybackend.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    @Autowired
    private StoreService storeService;


    //클라이언트로 store테이블 정보 전달
    @GetMapping("/allStores")
    public ResponseEntity<List<StoreDao>> getAllStores(){
        List<StoreDao> stores =   storeService.getAllStores();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    };

    @GetMapping("/{storeId}/image")
    public ResponseEntity<String> getStoreImageById(@PathVariable Long storeId) {
        String imageUrl = storeService.getStoreImageById(storeId);
        return new ResponseEntity<>(imageUrl, HttpStatus.OK);
    }
}
