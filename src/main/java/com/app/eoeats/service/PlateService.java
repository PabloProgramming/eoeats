package com.app.eoeats.service;

import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.PlateDto;
import com.app.eoeats.repository.PlateRepository;
import com.app.eoeats.service.mapper.PlateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateService {

    @Autowired
    PlateRepository plateRepository;

    @Autowired
    PlateMapper plateMapper;

    public PlateDto savePlateByCategory(PlateDto plateDto) {
        final Plate plate = plateMapper.requestDtoToEntity(plateDto);
        final Plate savedPlate = plateRepository.save(plate);
        return plateMapper.entityToDto(savedPlate);
    }



}
