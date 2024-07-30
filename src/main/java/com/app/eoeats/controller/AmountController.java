package com.app.eoeats.controller;

import com.app.eoeats.model.dto.AmountOfPlatesAndExtrasDto;
import com.app.eoeats.service.AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/amount")
public class AmountController {

    @Autowired
    AmountService amountService;

    @GetMapping("/{orderId}")
    private ResponseEntity<List<AmountOfPlatesAndExtrasDto>> getOrderPlatesAndExtras(@PathVariable final String orderId) {
        return ResponseEntity.ok(amountService.getPlatesAndExtrasByOrder(orderId));
    }
}
