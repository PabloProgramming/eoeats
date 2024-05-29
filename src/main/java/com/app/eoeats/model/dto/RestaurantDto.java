package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class RestaurantDto {

    private final String id;
    private final String email;
    private final String image;
    private final String name;
    private final String phone;
    private final String latitude;
    private final String longitude;
}
