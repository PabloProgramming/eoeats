package com.app.eoeats.service;

import com.app.eoeats.model.Order;
import com.app.eoeats.model.dto.OrderDto;
import com.app.eoeats.model.dto.OrderResponseDto;
import com.app.eoeats.repository.OrderRepository;
import com.app.eoeats.service.mapper.OrderMapper;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private Utils utils;

    public List<OrderResponseDto> getOrderInfoByRestaurantId(final String restaurantId) {
        final List<Order> orders = orderRepository.getOrdersByRestaurantId(utils.stringToUuid(restaurantId));
        return orderMapper.listEntityToListResponseDto(orders);
    }

    public OrderResponseDto saveOrder(final OrderDto orderDto) {
        final Order order = orderMapper.requestDtoToEntity(orderDto);
        final Order savedOrder = orderRepository.save(order);
        return orderMapper.entityToResponseDto(savedOrder);
    }

}


