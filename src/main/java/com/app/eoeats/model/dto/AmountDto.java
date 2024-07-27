package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class AmountDto {

    private final int amount;
    private final String description;
    private final double subTotalPrice;
    private final int type;
    private final String plateId;
    private final List<AmountExtraDto> amountExtraDtos;

}
