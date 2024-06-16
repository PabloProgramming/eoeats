package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class PlateWithExtrasResponseDto {

    private final String id;
    private final int type;
    private final String name;
    private final double price;
    private final List<AllergenResponseDto> allergens;
    private final List<ExtraResponseDto> extras;
    private final boolean isAvailable;
    private final boolean isKitchenPrinter;


}
