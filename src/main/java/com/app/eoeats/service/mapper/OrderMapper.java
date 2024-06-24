package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Amount;
import com.app.eoeats.model.Order;
import com.app.eoeats.model.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMapper {

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


    public int getAmountOfPlates(final List<Amount> amounts){
        int total = 0;
        for (Amount amount : amounts){
            total = total + amount.getAmount();
        }
        return total;
    }


}
