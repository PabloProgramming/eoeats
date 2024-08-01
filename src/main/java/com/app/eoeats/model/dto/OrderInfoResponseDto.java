package com.app.eoeats.model.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor

public class OrderInfoResponseDto {

    private final double totalPrice;
    private final List<AmountAndExtraResponseDto> amountAndExtraResponseDtos;
}
