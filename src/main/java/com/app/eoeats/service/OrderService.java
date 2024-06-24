package com.app.eoeats.service;

import com.app.eoeats.model.Order;
import com.app.eoeats.model.dto.OrderResponseDto;
import com.app.eoeats.repository.OrderRepository;
import com.app.eoeats.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;


    public List<Order> findOrdersById(final List<String> ordersIdStrings) {
        List<UUID> ordersIds = new ArrayList<>();
        for (String id : ordersIdStrings) {
            UUID uuid = UUID.fromString(id);
            ordersIds.add(uuid);
        }
        /* FUNCTIONAL PROGRAMMING STREAM METHOD
        List<UUID> IdsUuid = orderIdStrings.stream().
                .map(UUID::fromString)
                .toList();*/
        return orderRepository.findAllById(ordersIds);
    }


    public List<OrderResponseDto> getOrderInfo(final List<String> orderIds) {
        List<Order> orders = findOrdersById(orderIds);
        return orderMapper.listEntityToListResponseDto(orders);

    }


}