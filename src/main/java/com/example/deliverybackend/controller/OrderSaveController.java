package com.example.deliverybackend.controller;

import com.example.deliverybackend.entity.OrderDto;
import com.example.deliverybackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderSaveController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
        return ResponseEntity.ok("Order has been saved");
    }
}
