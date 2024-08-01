package com.app.eoeats.controller;

import com.app.eoeats.service.AmountExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/amountExtra")
public class AmountExtraController {

    @Autowired
    AmountExtraService amountExtraService;

    @DeleteMapping("/{amountExtraId}")
    private ResponseEntity<String> deletePlateFromOrder(@PathVariable final String amountExtraId) {
        return ResponseEntity.ok(amountExtraService.deleteAmountExtraFromOrder(amountExtraId));
    }
}
