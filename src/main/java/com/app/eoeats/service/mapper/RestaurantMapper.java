package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Restaurant;
import com.app.eoeats.model.dto.RestaurantDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestaurantMapper {

    public RestaurantDto entityToResponse(final Restaurant restaurant){
        return RestaurantDto.builder()
                .id(restaurant.getId().toString())
                .email(restaurant.getEmail())
                .image(restaurant.getImage())
                .imageId(restaurant.getImageId())
                .name((restaurant.getName()))
                .phone(restaurant.getPhone())
                .latitude(restaurant.getLatitude())
                .longitude(restaurant.getLongitude())
                .build();

    }

    public Restaurant requestToEntity (final RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant();
        if (restaurantDto.getId() != null) {
            restaurant.setId(UUID.fromString(restaurantDto.getId()));
        }
        restaurant.setEmail(restaurantDto.getEmail());
        restaurant.setImage(restaurantDto.getImage());
        restaurant.setImageId(restaurantDto.getImageId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setPhone(restaurantDto.getPhone());
        restaurant.setLatitude(restaurantDto.getLatitude());
        restaurant.setLongitude(restaurantDto.getLongitude());
        return restaurant;
    }



}