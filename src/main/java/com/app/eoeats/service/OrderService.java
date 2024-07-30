package com.app.eoeats.service;

import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.OrderNotFoundException;
import com.app.eoeats.model.Order;
import com.app.eoeats.model.dto.OrderDto;
import com.app.eoeats.model.dto.OrderResponseDto;
import com.app.eoeats.repository.OrderRepository;
import com.app.eoeats.service.mapper.OrderMapper;
import com.app.eoeats.utils.Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Boolean saveOrder(final OrderDto orderDto) {
        final Order order = orderMapper.requestDtoToEntity(orderDto);
        orderRepository.save(order);
        return true;
    }
    @SneakyThrows
    public String deleteOrder(final String orderId) {
        final Optional<Order> optionalOrder = orderRepository.findById(utils.stringToUuid(orderId));
        if (optionalOrder.isPresent()) {
            orderRepository.deleteById(UUID.fromString(orderId));
            return orderId;
        }
        throw new OrderNotFoundException(orderId);
    }

}


