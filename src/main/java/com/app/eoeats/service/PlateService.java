package com.app.eoeats.service;

import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.PlateAvailabilityDto;
import com.app.eoeats.model.dto.PlateDto;
import com.app.eoeats.model.dto.PlateResponseDto;
import com.app.eoeats.repository.PlateRepository;
import com.app.eoeats.service.mapper.PlateMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlateService {

    @Autowired
    PlateRepository plateRepository;

    @Autowired
    PlateMapper plateMapper;

    public PlateResponseDto savePlateByCategory(PlateDto plateDto) {
        final Plate plate = plateMapper.requestDtoToEntity(plateDto);
        final Plate savedPlate = plateRepository.save(plate);
        return plateMapper.entityToDto(savedPlate);
    }

    @SneakyThrows
    public String deletePlate(String plateId) {
        final Optional<Plate> optionalPlate = plateRepository.findById(UUID.fromString(plateId));
        if (optionalPlate.isPresent()) {
            plateRepository.deleteById(UUID.fromString(plateId));
            return plateId;
        }
        throw new Exception();

    }
    @SneakyThrows
    public PlateResponseDto updatePlateAvailability (final PlateAvailabilityDto plateAvailabilityDto){
        Optional<Plate> optionalPlate = plateRepository.findById(UUID.fromString(plateAvailabilityDto.getId()));
        if (optionalPlate.isPresent()){
            Plate plate = optionalPlate.get();
            plate.setAvailable(plateAvailabilityDto.isAvailable());
            plateRepository.save(plate);
            return plateMapper.entityToDto(plate);
        }
        throw new Exception();
    }


    @SneakyThrows
    public Plate findPlateById(String plateId){
        Optional<Plate> optionalPlate = plateRepository.findById(UUID.fromString(plateId));
        if (optionalPlate.isPresent()){
            return optionalPlate.get();
        }
        throw new Exception();
    }


}
