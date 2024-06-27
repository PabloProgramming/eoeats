package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Restaurant;
import com.app.eoeats.model.dto.RestaurantDto;
import com.app.eoeats.model.dto.RestaurantResponseDto;
import com.app.eoeats.model.dto.RestaurantResponseDtoClient;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantMapper {

    @Autowired
    private CategoriesResponseMapper restaurantCategoriesMapper;

    @Autowired
    private Utils utils;

    @Autowired
    private RestaurantResponseDtoClient restaurantResponseDtoClient;

    public RestaurantDto entityToResponse(final Restaurant restaurant) {
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

    public Restaurant requestToEntity(final RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        if (restaurantDto.getId() != null) {
            restaurant.setId(utils.stringToUuid(restaurantDto.getId()));
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

    public RestaurantResponseDto entityToResponseDto(final Restaurant restaurant) {
        return RestaurantResponseDto.builder()
                .id(restaurant.getId().toString())
                .email(restaurant.getEmail())
                .image(restaurant.getImage())
                .imageId(restaurant.getImageId())
                .name(restaurant.getName())
                .phone(restaurant.getPhone())
                .latitude(restaurant.getLatitude())
                .longitude(restaurant.getLongitude())
                .categoryDtoList(restaurantCategoriesMapper.listEntityToListResponseDto(restaurant.getCategories()))
                .build();
    }

    public RestaurantResponseDtoClient entityToResponseDtoClient(final Restaurant restaurant) {
        return RestaurantResponseDtoClient.builder()
                .id(restaurant.getId().toString())
                .name(restaurant.getName())
                .categoryDtoList(restaurantCategoriesMapper.listEntityToListResponseDto(restaurant.getCategories()))
                .build();


    }


}
