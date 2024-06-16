package com.app.eoeats.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class PlateByCategoryResponseDto {

    private final String id;
    private final int type;
    private final String name;
    private final boolean isAvailable;

}
