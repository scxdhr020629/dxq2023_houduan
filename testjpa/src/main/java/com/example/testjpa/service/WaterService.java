package com.example.testjpa.service;

import com.example.testjpa.entity.WaterEntity;

import java.util.List;


public interface WaterService {

    List<WaterEntity> findAll();
    void AddWater (WaterEntity waterEntity);
}
