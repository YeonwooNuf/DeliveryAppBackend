package com.example.deliverybackend.controller;


import com.example.deliverybackend.entity.HomeAddressDao;
import com.example.deliverybackend.entity.HomeAddressDto;
import com.example.deliverybackend.entity.UserDao;
import com.example.deliverybackend.service.HomeAddressService;
import com.example.deliverybackend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/HomeAddress")
public class HomeAddressController {

    @Autowired
    private HomeAddressService homeAddressService;

    @Autowired
    private UserService userService;

    @PostMapping("/save-HomeAddresses")
    public ResponseEntity<HomeAddressDao> saveHomeAddress(@RequestBody HomeAddressDto homeAddressDto){
        HomeAddressDao homeAddressDao = homeAddressService.saveHomeAddress(homeAddressDto);
        return new ResponseEntity<>(homeAddressDao,HttpStatus.CREATED);
    }


    //클라이언트로 Address 테이블 정보 전달
    @GetMapping("/allAddresses/{userNumber}")
    public ResponseEntity<String> getAllUserAddress(@PathVariable Long userNumber) {
        // 사용자 번호로 사용자 객체를 찾습니다.
        UserDao user = userService.findById(userNumber);
        System.out.println("Received user number: " + userNumber);

        // 사용자 객체에 해당하는 주소 목록을 가져옵니다.
        List<HomeAddressDao> addresses = homeAddressService.getAllUserAddress(user);

        // 주소 목록을 JSON 문자열로 변환합니다.
        String jsonAddresses = convertToJson(addresses);
        System.out.println(jsonAddresses);

        // 클라이언트로 전송합니다.
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(jsonAddresses);
    }

    // 객체를 JSON 문자열로 변환하는 메서드
    private String convertToJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
