package com.app.eoeats.controller;

import com.app.eoeats.model.dto.PlateAvailabilityDto;
import com.app.eoeats.model.dto.PlateDto;
import com.app.eoeats.model.dto.PlateResponseDto;
import com.app.eoeats.model.dto.PlateWithExtrasResponseDto;
import com.app.eoeats.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@Controller
@RequestMapping("/plate")
public class PlateController {


    @Autowired
    private PlateService plateService;

    @PostMapping
    private ResponseEntity<PlateResponseDto> savePlate(@RequestBody final PlateDto plateDto) {
        return ResponseEntity.ok(plateService.savePlateByCategory(plateDto));
    }

    @PutMapping
    private ResponseEntity<PlateResponseDto> updatePlate(@RequestBody final PlateDto plateDto) {
        return ResponseEntity.ok(plateService.savePlateByCategory(plateDto));
    }

    @PutMapping("/{isAvailable}")
    private ResponseEntity<PlateResponseDto> updatePlateAvailability(@RequestBody final PlateAvailabilityDto plateAvailabilityDto) {
        return ResponseEntity.ok(plateService.updatePlateAvailability(plateAvailabilityDto));
    }


    @DeleteMapping("/{plateId}")
    private ResponseEntity<String> deletePlate(@PathVariable final String plateId) {
        return ResponseEntity.ok(plateService.deletePlate(plateId));
    }

    @GetMapping("/{plateId}")
    private ResponseEntity<PlateWithExtrasResponseDto> getPlateInfo(@PathVariable final String plateId){
        return ResponseEntity.ok(plateService.getPlateInfo(plateId));
    }

}
