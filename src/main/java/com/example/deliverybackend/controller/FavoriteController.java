package com.example.deliverybackend.controller;


import com.example.deliverybackend.entity.FavoriteDao;
import com.example.deliverybackend.entity.FavoriteDto;
import com.example.deliverybackend.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//클라이언트에서 받아서 DB에 저장
@RestController
@RequestMapping("api/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/save-favorites")
    public ResponseEntity<String> saveFavorite(@RequestBody FavoriteDto favoriteDto){
        favoriteService.saveFavorite(favoriteDto);
        return new ResponseEntity<>("엔티티 생성 완료", HttpStatus.CREATED);
    }
    //클라이언트로 favorite테이블 정보 전달
    @GetMapping("/allFavorites")
    public ResponseEntity<List<FavoriteDao>> getAllFavorites(){
        List<FavoriteDao> favorites = favoriteService.getAllFavorite();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }
}
