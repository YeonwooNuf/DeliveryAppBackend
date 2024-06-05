package com.example.deliverybackend.service;


import com.example.deliverybackend.entity.*;
import com.example.deliverybackend.repository.FavoriteRepository;
import com.example.deliverybackend.repository.StoreRepository;
import com.example.deliverybackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreRepository storeRepository;



    public FavoriteDao saveFavorite(FavoriteDto favoriteDto) {
        FavoriteDao favoriteDao = new FavoriteDao();
        favoriteDao.setFavoriteUserNumber(favoriteDto.getFavoriteUserNumber());
        favoriteDao.setFavoriteStoreId(favoriteDto.getFavoriteStoreId());
        favoriteDao.setFavorite_storeImg(favoriteDto.getFavorite_storeImg());
        favoriteDao.setFavoriteStoreName(favoriteDto.getFavoriteStoreName());
        favoriteDao.setRating(favoriteDto.getRating());

        // userRepository와 storeRepository를 사용하여 UserDao와 StoreDao 엔티티를 데이터베이스에서 조회 없으면 null 반환함.
        UserDao userDao = userRepository.findById(favoriteDto.getFavoriteUserNumber()).orElse(null);
        StoreDao storeDao = storeRepository.findById(favoriteDto.getFavoriteStoreId()).orElse(null);
        favoriteDao.loadUserAndStore(userDao, storeDao);

        return favoriteRepository.save(favoriteDao);
    }


    @Transactional// 현재 스레드에 대해 실제 트랜잭션과 연결되어 있지 않기 때문에 발생 ->작업을 트랜잭션 관리 하에 수행하도록 함
    public void deleteFavoritesByUserAndStore(Long userNumber, Long storeId) {
        favoriteRepository.deleteByFavoriteUserNumberAndFavoriteStoreId(userNumber, storeId);
    }

    public List<FavoriteDao> getAllFavorites(){
        return favoriteRepository.findAll();
    }

    public List<FavoriteDao> getUserFavorites(Long userNumber) {
        return favoriteRepository.findByFavoriteUserNumber(userNumber);
    }




}

