package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class OrderResponseDto {

    private final String id;
    private final String date;
    private final boolean isPrinted;
    private final int tableNumber;
    private final int amountOfPlates;
}
