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

@RestController
@RequestMapping("/api/store")
public class SearchStoreController {

    @Autowired
    private StoreService storeService;

    // 특정 store_id에 해당하는 가게 정보 반환
    @GetMapping("/{store_id}")
    public ResponseEntity<StoreDao> getStoreById(@PathVariable("store_id") Long storeId) {
        StoreDao store = storeService.getStoreById(storeId);
        if (store != null) {
            return new ResponseEntity<>(store, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
