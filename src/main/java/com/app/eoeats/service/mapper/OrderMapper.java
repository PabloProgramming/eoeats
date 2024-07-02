package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Amount;
import com.app.eoeats.model.Order;
import com.app.eoeats.model.Restaurant;
import com.app.eoeats.model.dto.OrderDto;
import com.app.eoeats.model.dto.OrderResponseDto;
import com.app.eoeats.service.RestaurantService;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMapper {

    @Autowired
    private Utils utils;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private AmountMapper amountMapper;

    public List<OrderResponseDto> listEntityToListResponseDto(final List<Order> orders) {
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        for (Order order : orders) {
            OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                    .id(order.getId().toString())
                    .date(order.getDate())
                    .isPrinted(order.isPrinted())
                    .tableNumber(order.getTableNumber())
                    .amountOfPlates(getAmountOfPlates(order.getAmounts()))
                    .build();
            orderResponseDtoList.add(orderResponseDto);
        }
        return orderResponseDtoList;
    }


    public int getAmountOfPlates(final List<Amount> amounts) {
        int total = 0;
        for (Amount amount : amounts) {
            total = total + amount.getAmount();
        }
        return total;
    }

    public Order requestDtoToEntity(final OrderDto orderDto) {
        Order order = new Order();
        if (orderDto.getId() != null) {
            order.setId(utils.stringToUuid(orderDto.getId()));
        }
        order.setDate(orderDto.getDate());
        order.setTableNumber(orderDto.getTableNumber());
        order.setTotalPrice(orderDto.getTotalPrice());
        final Restaurant restaurant = restaurantService.findRestaurantById(orderDto.getRestaurantId());
        order.setRestaurant(restaurant);
        order.setAmounts(amountMapper.listDtoToEntity(orderDto.getAmountDtos()));
        return order;
    }

    public OrderResponseDto entityToResponseDto(final Order order) {
        return OrderResponseDto.builder()
                .id(order.getId().toString())
                .date(order.getDate())
                .isPrinted(order.isPrinted())
                .tableNumber(order.getTableNumber())
                .totalPrice(order.getTotalPrice())
                .amountOfPlates(getAmountOfPlates(order.getAmounts()))
                .build();
    }

}
