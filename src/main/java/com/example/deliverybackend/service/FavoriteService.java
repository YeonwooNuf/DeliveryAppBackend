package com.example.deliverybackend.service;


import com.example.deliverybackend.entity.FavoriteDao;
import com.example.deliverybackend.entity.FavoriteDto;
import com.example.deliverybackend.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;


    public void saveFavorite(FavoriteDto favoriteDto) {
        FavoriteDao favoriteDao = new FavoriteDao();
        favoriteDao.setFavorite_userId(favoriteDto.getFavorite_userId());
        favoriteDao.setFavorite_storeId(favoriteDto.getFavorite_storeId());
        favoriteDao.setFavorite_storeImg(favoriteDto.getFavorite_storeImg());
        favoriteDao.setRating(favoriteDto.getRating());
        favoriteRepository.save(favoriteDao);
    }

    public List<FavoriteDao> getAllFavorite(){
        return favoriteRepository.findAll();
    }
}
