package com.example.deliverybackend.controller;


import com.example.deliverybackend.entity.MenuDao;
import com.example.deliverybackend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    //클라이언트로 menu테이블 정보 전달
    @GetMapping("/allMenus")
    public ResponseEntity<List<MenuDao>> getAllMenus(){
      List<MenuDao> menus =   menuService.getAllMenus();
      return new ResponseEntity<>(menus, HttpStatus.OK);
    };




}
