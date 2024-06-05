package com.app.eoeats.service;

import com.app.eoeats.model.RestaurantConfiguration;
import com.app.eoeats.model.dto.RestaurantConfigurationDto;
import com.app.eoeats.repository.RestaurantConfigurationRepository;
import com.app.eoeats.service.mapper.RestaurantConfigurationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantConfigurationService {

    @Autowired
    RestaurantConfigurationRepository restaurantConfigurationRepository;

    @Autowired
    RestaurantConfigurationMapper restaurantConfigurationMapper;

    public RestaurantConfigurationDto updateConfiguration(RestaurantConfigurationDto restaurantConfigurationDto){
        RestaurantConfiguration restaurantConfiguration = restaurantConfigurationMapper.requestToEntity(restaurantConfigurationDto);
        RestaurantConfiguration updatedRestaurantConfiguration = restaurantConfigurationRepository.save(restaurantConfiguration);
        return restaurantConfigurationMapper.entityToResponse(updatedRestaurantConfiguration);




    }

}
