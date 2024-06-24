package com.app.eoeats.repository;

import com.app.eoeats.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> getOrdersByRestaurantId(UUID restaurantId);


}
