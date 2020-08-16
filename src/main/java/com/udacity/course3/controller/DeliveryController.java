package com.udacity.course3.controller;

import com.udacity.course3.data.Delivery;
import com.udacity.course3.data.RecipientAndPrice;
import com.udacity.course3.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/{name}")
    public List<Delivery> getDeliveries(@PathVariable String name) {
        return deliveryService.getDeliveriesByName(name);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }
}
