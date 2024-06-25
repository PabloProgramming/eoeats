package com.app.eoeats.controller;

import com.app.eoeats.model.dto.RestaurantDto;
import com.app.eoeats.model.dto.RestaurantResponseDto;
import com.app.eoeats.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping ("/{restaurantId}")
    private ResponseEntity<RestaurantResponseDto> getRestaurantInfo(@PathVariable final String restaurantId){
        return ResponseEntity.ok(restaurantService.getRestaurantInfo(restaurantId));
    }

    @PutMapping
    private ResponseEntity<RestaurantDto> updateRestaurantInfo(@RequestBody final RestaurantDto restaurantDto) {
        return ResponseEntity.ok(restaurantService.updateRestaurantInfo(restaurantDto));
    }
}
