package com.app.eoeats.service.mapper;

import com.app.eoeats.model.RestaurantConfiguration;
import com.app.eoeats.model.dto.RestaurantConfigurationDto;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantConfigurationMapper {

    @Autowired
    Utils utils;

    public RestaurantConfiguration requestToEntity(final RestaurantConfigurationDto restaurantConfigurationDto) {
        RestaurantConfiguration restaurantConfiguration = new RestaurantConfiguration();
        if (restaurantConfigurationDto.getId() != null) {
            restaurantConfiguration.setId(utils.stringToUuid(restaurantConfigurationDto.getId()));
        }
        restaurantConfiguration.setMailConfirmation(restaurantConfigurationDto.getMailConfirmation());
        restaurantConfiguration.setPrintConfirmation(restaurantConfigurationDto.getPrintConfirmation());
        return restaurantConfiguration;

    }


    public RestaurantConfigurationDto entityToResponse(final RestaurantConfiguration restaurantConfiguration) {
        return RestaurantConfigurationDto.builder()
                .id(restaurantConfiguration.getId().toString())
                .mailConfirmation(restaurantConfiguration.getMailConfirmation())
                .printConfirmation(restaurantConfiguration.getPrintConfirmation())
                .build();
    }
}
