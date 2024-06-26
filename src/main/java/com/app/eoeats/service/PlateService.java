package com.app.eoeats.service;

import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.PlateNotFoundException;
import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.PlateAvailabilityDto;
import com.app.eoeats.model.dto.PlateDto;
import com.app.eoeats.model.dto.PlateResponseDto;
import com.app.eoeats.model.dto.PlateWithExtrasResponseDto;
import com.app.eoeats.repository.PlateRepository;
import com.app.eoeats.service.mapper.PlateMapper;
import com.app.eoeats.utils.Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlateService {

    @Autowired
    private PlateRepository plateRepository;

    @Autowired
    private PlateMapper plateMapper;

    @Autowired
    private Utils utils;

    public PlateResponseDto savePlateByCategory(final PlateDto plateDto) {
        final Plate plate = plateMapper.requestDtoToEntity(plateDto);
        final Plate savedPlate = plateRepository.save(plate);
        return plateMapper.entityToDto(savedPlate);
    }

    @SneakyThrows
    public String deletePlate(final String plateId) {
        final Optional<Plate> optionalPlate = plateRepository.findById(utils.stringToUuid(plateId));
        if (optionalPlate.isPresent()) {
            plateRepository.deleteById(UUID.fromString(plateId));
            return plateId;
        }
        throw new PlateNotFoundException(plateId);

    }

    @SneakyThrows
    public PlateResponseDto updatePlateAvailability(final PlateAvailabilityDto plateAvailabilityDto) {
        Optional<Plate> optionalPlate = plateRepository.findById(utils.stringToUuid(plateAvailabilityDto.getId()));
        if (optionalPlate.isPresent()) {
            Plate plate = optionalPlate.get();
            plate.setAvailable(plateAvailabilityDto.isAvailable());
            plateRepository.save(plate);
            return plateMapper.entityToDto(plate);
        }
        throw new PlateNotFoundException(plateAvailabilityDto.getId());
    }

    public PlateWithExtrasResponseDto getPlateInfo(final String plateId) {
        Plate plate = findPlateById(plateId);
        return plateMapper.entityToResponseDto(plate);
    }


    @SneakyThrows
    public Plate findPlateById(final String plateId) {
        Optional<Plate> optionalPlate = plateRepository.findById(utils.stringToUuid(plateId));
        if (optionalPlate.isPresent()) {
            return optionalPlate.get();
        }
        throw new PlateNotFoundException(plateId);
    }

}
