package com.example.testjpa.service.impl;

import com.example.testjpa.entity.WaterEntity;
import com.example.testjpa.repository.WaterEntityRepository;
import com.example.testjpa.service.WaterService;
import org.springframework.stereotype.Service;

@Service
public class WaterServicelmpl implements WaterService {
    private final WaterEntityRepository waterRepository;

    public WaterServicelmpl(WaterEntityRepository waterRepository) {
        this.waterRepository = waterRepository;
    }
    public WaterEntity AddWater(WaterEntity waterEntity){
        return waterRepository.save(waterEntity);
    }
}
