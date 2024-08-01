package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor

public class AmountAndExtraResponseDto {

    private final int amountOfPlate;
    private final String name;
    private final double platePrice;
    private final List<ExtraByAmountResponseDto> extraByAmountResponseDtos;

}

