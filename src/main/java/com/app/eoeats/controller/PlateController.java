package com.app.eoeats.controller;

import com.app.eoeats.model.dto.PlateDto;
import com.app.eoeats.model.dto.ResponsePlateDto;
import com.app.eoeats.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/plate")
public class PlateController {


    @Autowired
    PlateService plateService;

    @PostMapping
    private ResponseEntity<ResponsePlateDto> savePlate(@RequestBody final PlateDto plateDto){
        return ResponseEntity.ok(plateService.savePlateByCategory(plateDto));
    }

    @DeleteMapping ("/{plateId}")
    private ResponseEntity<String> deletePlate(@PathVariable final String plateId){
        return ResponseEntity.ok(plateService.deletePlate(plateId));
    }

}
