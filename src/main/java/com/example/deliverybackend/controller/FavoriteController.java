package com.example.deliverybackend.controller;

import com.example.deliverybackend.entity.FavoriteDao;
import com.example.deliverybackend.entity.FavoriteDto;
import com.example.deliverybackend.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    //클라이언트에서 받아와서 저장
    @PostMapping("/save-favorites")
    public ResponseEntity<FavoriteDao> saveFavorite(@RequestBody FavoriteDto favoriteDto) {
        FavoriteDao favorite = favoriteService.saveFavorite(favoriteDto);
        return new ResponseEntity<>(favorite, HttpStatus.CREATED);
    }


    //클라이언트에서 하트 제거시 즐겨찾기 삭제
    @DeleteMapping("/delete-favorites/{userNumber}/{storeId}")
    public ResponseEntity<?> deleteFavoritesByUserAndStore(@PathVariable Long userNumber, @PathVariable Long storeId) {
        favoriteService.deleteFavoritesByUserAndStore(userNumber, storeId);
        return ResponseEntity.ok().build();
    }

    //클라이언트로 favorite테이블 정보 전달
    @GetMapping("/allFavorites")
    public ResponseEntity<List<FavoriteDao>> getAllFavorites() { // 반환 타입 변경
        List<FavoriteDao> favorites = favoriteService.getAllFavorites(); // 변경된 메소드 호출
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }
    @GetMapping("/userFavorites/{userNumber}")
    public ResponseEntity<List<FavoriteDao>> getUserFavorites(@PathVariable Long userNumber) {
        List<FavoriteDao> favorites = favoriteService.getUserFavorites(userNumber);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8) // JSON 데이터를 전송할 때 UTF-8 캐릭터셋 설정
                .body(favorites);
    }
}




