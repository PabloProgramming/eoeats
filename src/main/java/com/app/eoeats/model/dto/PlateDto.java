package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class PlateDto {

    private final String id;
    private final int type;
    private final String name;
    private final double price;
    private final String image;
    private final String categoryId;
    private final List<String> allergens;
    private final boolean isAvailable;
    private final boolean isKitchenPrinter;
}
