package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Extra;
import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.ExtraDto;
import com.app.eoeats.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExtraMapper {


    @Autowired
    PlateService plateService;

    public Extra requestDtoToEntity(final ExtraDto extraDto) {
        Extra extra = new Extra();
        if (extraDto.getId() != null) {
            extra.setId(UUID.fromString(extraDto.getId()));
        }

        extra.setName(extraDto.getName());
        extra.setPrice(extraDto.getPrice());
        final Plate plate = plateService.findPlateById(extraDto.getPlateId());
        extra.setPlate(plate);
        return extra;
    }

    public ExtraDto entityToDto(final Extra extra) {
        return ExtraDto.builder()
                .id(extra.getId().toString())
                .name(extra.getName())
                .price(extra.getPrice())
                .plateId(extra.getPlate().getId().toString())
                .build();
    }

}
