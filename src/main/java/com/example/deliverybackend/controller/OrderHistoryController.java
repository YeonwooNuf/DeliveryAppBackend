package com.example.deliverybackend.controller;

import com.example.deliverybackend.entity.OrderDao;
import com.example.deliverybackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderhistory")
public class OrderHistoryController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDao>> getOrderHistory(@RequestParam Long userNumber) {
        List<OrderDao> orderHistory = orderService.showOrder(userNumber);
        return ResponseEntity.ok(orderHistory);
    }
}
