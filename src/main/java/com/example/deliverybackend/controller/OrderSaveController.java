package com.example.deliverybackend.controller;

import com.example.deliverybackend.entity.OrderDao;
import com.example.deliverybackend.entity.OrderDto;
import com.example.deliverybackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderSaveController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderSaveController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders")
    public String receiveOrder(@RequestBody OrderDto orderDto) {
        // 받은 주문 데이터를 OrderDao로 변환하여 저장합니다.
        OrderDao orderDao = new OrderDao(
                orderDto.getStoreId(),
                orderDto.getStoreName(),
                orderDto.getUserNumber(),
                orderDto.getProductNames(),
                orderDto.getTotalPrice()
        );
        orderRepository.save(orderDao);

        // 성공적으로 주문을 저장했다는 응답을 반환합니다.
        return "주문이 성공적으로 접수되었습니다.";
    }
}
