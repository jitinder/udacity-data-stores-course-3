package com.udacity.course3.repository;

import com.udacity.course3.data.CandyData;

import java.util.List;

public interface CandyDAO {
    public List<CandyData> getAllCandies();
    public void addCandyToDelivery(Long candyId, Long deliveryId);
    public List<CandyData> getCandiesForDelivery(Long deliveryId);
}
