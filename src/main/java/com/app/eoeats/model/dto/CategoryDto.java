package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class CategoryDto {

    private final String id;
    private final String image;
    private final String name;
    private final String restaurantId;
}
