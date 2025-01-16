package com.example.deliverybackend.service;

import com.example.deliverybackend.entity.OrderDao;
import com.example.deliverybackend.entity.OrderDto;
import com.example.deliverybackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(OrderDto orderDto) {
        OrderDao orderDao = new OrderDao();
        // OrderDto에서 OrderDao로 데이터를 매핑합니다. 실제 구현에서는 ModelMapper 라이브러리 사용을 고려해 볼 수 있습니다.
        // 여기서는 단순화를 위해 직접 매핑합니다.
        orderDao.setStoreId(orderDto.getStoreId());
        orderDao.setStoreName(orderDto.getStoreName());
        orderDao.setUserNumber(orderDto.getUserNumber());
        // productNames는 리스트를 String으로 변환하여 저장하는 예시입니다. 실제 구현에서는 적절한 변환 로직 필요
        orderDao.setProductNames(String.join(",", orderDto.getProductNames()));
        orderDao.setTotalPrice(orderDto.getTotalPrice());

        orderRepository.save(orderDao);
    }

    public void showOrder(OrderDto orderDto) {
        // userNumber로 필터링하여 사용자의 주문 내역만 리스트에 띄움
        if (orderDto.getUserNumber() != null) {
            Long userNumber = orderDto.getUserNumber();
            List<OrderDao> orderList = orderRepository.findByUserNumber(userNumber);
        } else {
            // userNumber가 null이면 저장하지 않고 예외 처리 또는 로그 등을 수행
            throw new IllegalArgumentException("UserNumber cannot be null");
        }
    }

    public List<OrderDao> showOrder(Long userNumber) {
        // userNumber로 주문 내역을 조회하여 반환
        return orderRepository.findByUserNumber(userNumber);
    }
}