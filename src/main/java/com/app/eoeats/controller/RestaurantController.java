package com.app.eoeats.controller;

import com.app.eoeats.model.dto.RestaurantDto;
import com.app.eoeats.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PutMapping
    private ResponseEntity<RestaurantDto> updateRestaurantInfo(@RequestBody RestaurantDto restaurantDto){
    return ResponseEntity.ok(restaurantService.updateRestaurantInfo(restaurantDto));



    }
}
