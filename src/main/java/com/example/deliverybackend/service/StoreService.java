package com.example.deliverybackend.service;

import com.example.deliverybackend.entity.StoreDao;
import com.example.deliverybackend.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<StoreDao> getAllStores(){
        return storeRepository.findAll();
    };

    public StoreDao getStoreById(Long storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }

    public String getStoreImageById(Long storeId) {
        StoreDao store = storeRepository.findById(storeId).orElse(null);
        if (store != null) {
            return store.getStoreImg();
        } else {
            return null;
        }
    }
}
