package com.example.deliverybackend.controller;

import com.example.deliverybackend.model.ProductDao;
import com.example.deliverybackend.model.ProductDto;
import com.example.deliverybackend.model.UserDao;
import com.example.deliverybackend.model.UserDto;
import com.example.deliverybackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired

    private ProductService productService;

    @PostMapping("/save-products")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto); // UserService를 통해 유저 저장
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }
    //클라이언트로 product테이블 정보 전달
    @GetMapping("/allProducts") // 경로 변경
    public ResponseEntity<List<ProductDao>> getAllProducts() { // 반환 타입 변경
        List<ProductDao> products = productService.getAllProducts(); // 변경된 메소드 호출
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
