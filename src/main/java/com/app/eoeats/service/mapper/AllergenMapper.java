package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Allergen;
import com.app.eoeats.model.dto.ResponseAllergenDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllergenMapper {
    @SneakyThrows
    public List<ResponseAllergenDto> entityToDto(final List<Allergen> allergens) {
        ResponseAllergenDto responseAllergenDto = new ResponseAllergenDto();
        List<ResponseAllergenDto> allergensDto = new ArrayList<>();
        for (Allergen allergen1 : allergens) {
            if (allergen1 != null) {
                responseAllergenDto.setId(allergen1.getId().toString());
                responseAllergenDto.setName(allergen1.getName());
                allergensDto.add(responseAllergenDto);
            } else
                throw new Exception();

        }
        return allergensDto;

    }


}
