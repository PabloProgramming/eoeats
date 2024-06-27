package com.app.eoeats.service;

import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.RestaurantNotFoundException;
import com.app.eoeats.model.Restaurant;
import com.app.eoeats.model.dto.RestaurantDto;
import com.app.eoeats.model.dto.RestaurantResponseDto;
import com.app.eoeats.model.dto.RestaurantResponseDtoClient;
import com.app.eoeats.repository.RestaurantRepository;
import com.app.eoeats.service.mapper.RestaurantMapper;
import com.app.eoeats.utils.Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private Utils utils;


    public RestaurantDto updateRestaurantInfo(final RestaurantDto restaurantDto) {
        final Restaurant restaurant = restaurantMapper.requestToEntity(restaurantDto);
        final Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.entityToResponse(updatedRestaurant);
    }

    @SneakyThrows
    public Restaurant findRestaurantById(final String restaurantId) {
       final Optional<Restaurant> restaurantOptional = restaurantRepository.findById(utils.stringToUuid(restaurantId));
        if (restaurantOptional.isPresent()) {
            return restaurantOptional.get();
        }
        throw new RestaurantNotFoundException(restaurantId);
    }

    public RestaurantResponseDto getRestaurantInfo(final String restaurantId) {
        Restaurant restaurant = findRestaurantById(restaurantId);
        return restaurantMapper.entityToResponseDto(restaurant);
    }

    @SneakyThrows
    public RestaurantResponseDtoClient getRestaurantByName(final String restaurantName) {
        final Optional<Restaurant> restaurantOptional = restaurantRepository.getRestaurantByName(restaurantName);
        if (restaurantOptional.isPresent()) {
            return restaurantMapper.entityToResponseDtoClient(restaurantOptional.get());
        }
        throw new Exception();
    }

}
