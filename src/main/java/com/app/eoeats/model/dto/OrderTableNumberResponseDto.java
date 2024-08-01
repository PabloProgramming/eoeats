package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor

public class OrderTableNumberResponseDto {

    private final int tableNumber;
    private final List<OrderInfoResponseDto> orderInfoResponseDtos;

}
