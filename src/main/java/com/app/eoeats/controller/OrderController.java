package com.app.eoeats.controller;

import com.app.eoeats.model.dto.OrderDto;
import com.app.eoeats.model.dto.OrderResponseDto;
import com.app.eoeats.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{restaurantId}")
    private ResponseEntity<List<OrderResponseDto>> getOrderInfo(@PathVariable final String restaurantId) {
        return ResponseEntity.ok(orderService.getOrderInfoByRestaurantId(restaurantId));
    }

    @PostMapping
    private ResponseEntity<Boolean> saveOrder(@RequestBody final OrderDto orderDto) {
        return ResponseEntity.ok(orderService.saveOrder(orderDto));
    }

}
