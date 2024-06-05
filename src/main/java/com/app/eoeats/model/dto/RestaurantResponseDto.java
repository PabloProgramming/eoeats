package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class RestaurantResponseDto {

    private final String id;
    private final String email;
    private final String image;
    private final String imageId;
    private final String name;
    private final String phone;
    private final String latitude;
    private final String longitude;
    private final List<CategoryResponseDto> categoryDtoList;
}
