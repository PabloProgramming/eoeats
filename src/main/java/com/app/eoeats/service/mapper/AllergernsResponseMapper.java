package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Allergen;
import com.app.eoeats.model.dto.AllergenResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllergernsResponseMapper {

    public List<AllergenResponseDto> entityListToListResponseDto(final List<Allergen> allergens) {
        List<AllergenResponseDto> allergensResponseDtos = new ArrayList<>();
        for (Allergen allergen : allergens) {
            AllergenResponseDto allergenResponseDto = AllergenResponseDto.builder()
                    .id(allergen.getId().toString())
                    .name(allergen.getName())
                    .build();
            allergensResponseDtos.add(allergenResponseDto);
        }
        return allergensResponseDtos;

    }
}
