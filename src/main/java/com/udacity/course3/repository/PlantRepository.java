package com.udacity.course3.repository;

import com.udacity.course3.data.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    Boolean existsPlantByIdAndDeliveryComplete(Long id, Boolean complete);

    //you can return a primitive directly
    @Query("select p.delivery.complete from Plant p where p.id = :plantId")
    Boolean deliveryCompleted(Long plantId);

    List<Plant> findByPriceLessThan(BigDecimal price);
}
