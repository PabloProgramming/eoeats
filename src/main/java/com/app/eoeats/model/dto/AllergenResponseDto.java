package com.app.eoeats.model.dto;

import lombok.*;

@Builder
@Getter
@RequiredArgsConstructor
public class AllergenResponseDto {

    private final String id;
    private final String name;
}
