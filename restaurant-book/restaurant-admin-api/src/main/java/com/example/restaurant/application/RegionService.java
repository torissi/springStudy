package com.example.restaurant.application;

import com.example.restaurant.domain.Region;
import com.example.restaurant.domain.RegionRepository;
import com.example.restaurant.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRigions() {
        List<Region> regions = regionRepository.findAll();
       //regions.add(Region.builder().name("Seoul").build());
        return regions;
    }
}
