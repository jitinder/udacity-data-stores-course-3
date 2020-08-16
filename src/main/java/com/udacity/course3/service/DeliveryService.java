package com.udacity.course3.service;

import com.udacity.course3.data.Delivery;
import com.udacity.course3.data.RecipientAndPrice;
import com.udacity.course3.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public List<Delivery> getDeliveriesByName(String name){
        System.out.println(deliveryRepository.findDeliveriesByName(name));
        return deliveryRepository.findDeliveriesByName(name);
    }

    public Delivery getDelivery(Long id){
        return deliveryRepository.find(id);
    }

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }
}
