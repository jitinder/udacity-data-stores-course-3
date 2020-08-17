package com.udacity.course3.service;

import com.udacity.course3.data.Plant;
import com.udacity.course3.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public Long save(Plant p){
        Plant saved = plantRepository.save(p);
        return saved.getId();
    }

    public boolean isDelivered(Long id){
        return plantRepository.existsPlantByIdAndDeliveryComplete(id, true);
    }

    public List<Plant> cheaperThan(BigDecimal price){
        return plantRepository.findByPriceLessThan(price);
    }
}
