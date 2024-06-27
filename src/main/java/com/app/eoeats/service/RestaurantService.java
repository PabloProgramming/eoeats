package com.app.eoeats.service;

import com.app.eoeats.model.Restaurant;
import com.app.eoeats.model.dto.RestaurantDto;
import com.app.eoeats.model.dto.RestaurantResponseDto;
import com.app.eoeats.model.dto.RestaurantResponseDtoClient;
import com.app.eoeats.repository.RestaurantRepository;
import com.app.eoeats.service.mapper.RestaurantMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMapper restaurantMapper;


    public RestaurantDto updateRestaurantInfo(final RestaurantDto restaurantDto) {
        final Restaurant restaurant = restaurantMapper.requestToEntity(restaurantDto);
        final Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.entityToResponse(updatedRestaurant);
    }

    @SneakyThrows
    public Restaurant findRestaurantById(final String restaurantId) {
        final Optional<Restaurant> restaurantOptional = restaurantRepository.findById(UUID.fromString(restaurantId));
        if (restaurantOptional.isPresent()) {
            return restaurantOptional.get();
        }
        throw new Exception();
    }

    public RestaurantResponseDto getRestaurantInfo(final String restaurantId) {
        final Restaurant restaurant = findRestaurantById(restaurantId);
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
