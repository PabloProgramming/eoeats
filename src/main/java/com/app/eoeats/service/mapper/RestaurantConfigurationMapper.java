package com.app.eoeats.service.mapper;

import com.app.eoeats.model.RestaurantConfiguration;
import com.app.eoeats.model.dto.RestaurantConfigurationDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestaurantConfigurationMapper {

    public RestaurantConfiguration requestToEntity(final RestaurantConfigurationDto restaurantConfigurationDto) {
        RestaurantConfiguration restaurantConfiguration = new RestaurantConfiguration();
        restaurantConfiguration.setId(UUID.fromString(restaurantConfigurationDto.getId()));
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
