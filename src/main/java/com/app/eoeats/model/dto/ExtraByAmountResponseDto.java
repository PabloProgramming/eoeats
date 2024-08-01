package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor

public class ExtraByAmountResponseDto {

    private final String name;
    private final double extraPrice;
}
