package com.example.testjpa.service.impl;

import com.example.testjpa.entity.WaterEntity;
import com.example.testjpa.repository.WaterEntityRepository;
import com.example.testjpa.service.WaterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterServicelmpl implements WaterService {
    private final WaterEntityRepository waterRepository;

    public WaterServicelmpl(WaterEntityRepository waterRepository) {
        this.waterRepository = waterRepository;
    }

    @Override
    public List<WaterEntity> findAll() {
        return (List<WaterEntity>) waterRepository.findAll();
    }

    public void AddWater(WaterEntity waterEntity){
        waterRepository.save(waterEntity);
    }

}
