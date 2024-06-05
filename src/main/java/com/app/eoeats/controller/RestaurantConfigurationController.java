package com.app.eoeats.controller;

import com.app.eoeats.model.dto.RestaurantConfigurationDto;
import com.app.eoeats.service.RestaurantConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurantConfiguration")
public class RestaurantConfigurationController {

    @Autowired
    RestaurantConfigurationService restaurantConfigurationService;

    @PutMapping
    private ResponseEntity<RestaurantConfigurationDto> updateRestaurantConfiguration(@RequestBody RestaurantConfigurationDto restaurantConfigurationDto) {
        return ResponseEntity.ok(restaurantConfigurationService.updateConfiguration(restaurantConfigurationDto));
    }
}
