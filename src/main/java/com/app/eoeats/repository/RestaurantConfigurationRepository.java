package com.app.eoeats.repository;

import com.app.eoeats.model.RestaurantConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantConfigurationRepository extends JpaRepository<RestaurantConfiguration, UUID> {


}
