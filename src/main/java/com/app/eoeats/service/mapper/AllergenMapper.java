package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Allergen;
import com.app.eoeats.model.dto.AllergenResponseDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllergenMapper {
    @SneakyThrows
    public List<AllergenResponseDto> entityToDto(final List<Allergen> allergens) {
        List<AllergenResponseDto> allergensDto = new ArrayList<>();
        for (Allergen allergen : allergens) {
            if (allergen != null) {
                AllergenResponseDto allergenResponseDto = AllergenResponseDto.builder()
                        .id(allergen.getId().toString())
                        .name(allergen.getName())
                        .build();
                allergensDto.add(allergenResponseDto);
            } else
                throw new Exception();

        }
        return allergensDto;

    }


}
