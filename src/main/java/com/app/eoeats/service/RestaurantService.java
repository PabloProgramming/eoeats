package com.app.eoeats.service;

import com.app.eoeats.model.Restaurant;
import com.app.eoeats.model.dto.RestaurantDto;
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
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantMapper restaurantMapper;



    public RestaurantDto updateRestaurantInfo(final RestaurantDto restaurantDto) {
        final Restaurant restaurant = restaurantMapper.requestToEntity(restaurantDto);
        final Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.entityToResponse(updatedRestaurant);
    }

    @SneakyThrows
    public Restaurant findRestaurantById(UUID restaurantId) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            return restaurantOptional.get();
        }
        throw new Exception();
    }

}
