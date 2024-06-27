package com.app.eoeats.service;

import com.app.eoeats.model.Order;
import com.app.eoeats.model.dto.OrderResponseDto;
import com.app.eoeats.repository.OrderRepository;
import com.app.eoeats.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public List<OrderResponseDto> getOrderInfoByRestaurantId(final String restaurantId) {
        final List<Order> orders = orderRepository.getOrdersByRestaurantId(UUID.fromString(restaurantId));
        return orderMapper.listEntityToListResponseDto(orders);
    }


}


