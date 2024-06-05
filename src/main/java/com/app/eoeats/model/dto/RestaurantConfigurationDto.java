package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class RestaurantConfigurationDto {

    private final String id;
    private final int mailConfirmation;
    private final int printConfirmation;
}
