package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class OrderDto {

    private final String id;
    private final String date;
    private final int tableNumber;
    private final double totalPrice;
    private final List<AmountDto> amountDtos;
    private final String restaurantId;
}
