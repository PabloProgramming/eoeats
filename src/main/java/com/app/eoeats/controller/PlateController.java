package com.app.eoeats.controller;

import com.app.eoeats.model.dto.PlateDto;
import com.app.eoeats.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/plate")
public class PlateController {


    @Autowired
    PlateService plateService;

    @PostMapping
    private ResponseEntity<PlateDto> savePlate(@RequestBody PlateDto plateDto){
        return ResponseEntity.ok(plateService.savePlateByCategory(plateDto));
    }

}
