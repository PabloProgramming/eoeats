package com.app.eoeats.controller;

import com.app.eoeats.model.dto.ExtraDto;
import com.app.eoeats.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/extra")
public class ExtraController {

    @Autowired
    private ExtraService extraService;

    @PostMapping
    private ResponseEntity<ExtraDto> saveExtra(@RequestBody final ExtraDto extraDto){
        return ResponseEntity.ok(extraService.saveExtra(extraDto));
    }

    @PutMapping
    private ResponseEntity<ExtraDto> updateExtra(@RequestBody final ExtraDto extraDto) {
        return ResponseEntity.ok(extraService.saveExtra(extraDto));

    }

    @DeleteMapping ("/{extraId}")
    private ResponseEntity<String> deleteExtra(@PathVariable final String extraId){
        return ResponseEntity.ok(extraService.deleteExtra(extraId));
    }
}
