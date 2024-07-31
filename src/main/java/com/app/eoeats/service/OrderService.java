package com.app.eoeats.service;

import com.app.eoeats.model.Order;
import com.app.eoeats.model.dto.OrderDto;
import com.app.eoeats.model.dto.OrderResponseDto;
import com.app.eoeats.repository.OrderRepository;
import com.app.eoeats.service.mapper.OrderMapper;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private Utils utils;

    @Autowired
    private AmountService amountService;


    public List<OrderResponseDto> getOrderInfoByRestaurantId(final String restaurantId) {
        final List<Order> orders = orderRepository.getOrdersByRestaurantId(utils.stringToUuid(restaurantId));
        return orderMapper.listEntityToListResponseDto(orders);
    }

    public Boolean saveOrder(final OrderDto orderDto) {
        final Order order = orderMapper.requestDtoToEntity(orderDto);
        orderRepository.save(order);
        return true;
    }

    public List<String> deleteOrderByTableNumber(final int tableNumber) {
        List<Order> orders = orderRepository.getOrderByTableNumber(tableNumber);
        List<String> orderIds = new ArrayList<>();
        for (Order order : orders) {
            String orderId = order.getId().toString();
            orderIds.add(orderId);
            amountService.deleteAmountsByOrderId(orderId);
            orderRepository.delete(order);
        }
        return orderIds;
    }

}


