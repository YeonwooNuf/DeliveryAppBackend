package com.example.deliverybackend.controller;


import com.example.deliverybackend.entity.MenuDao;
import com.example.deliverybackend.entity.MenuDto;
import com.example.deliverybackend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    //클라이언트로 menu테이블 정보 전달
    @GetMapping("/allMenus")
    public ResponseEntity<List<MenuDto>> getAllMenus() {
        List<MenuDao> menuDaos = menuService.getAllMenus();
        List<MenuDto> menuDtos = menuDaos.stream()
                .map(MenuDao::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(menuDtos, HttpStatus.OK);
    }




}
