package com.app.eoeats.repository;

import com.app.eoeats.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

    Optional<Restaurant> getRestaurantByName(String restaurantName);

}
