package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ExtraDto {

    private final String id;
    private final String name;
    private final double price;
    private final String plateId;
}
