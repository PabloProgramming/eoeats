package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class RestaurantResponseDtoClient {

    private final String id;
    private final String name;
    private final List<CategoryResponseDto> categoryDtoList;
}
