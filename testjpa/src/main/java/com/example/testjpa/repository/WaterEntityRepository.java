package com.example.testjpa.repository;

import com.example.testjpa.entity.WaterEntity;
import org.springframework.data.repository.CrudRepository;

public interface WaterEntityRepository extends CrudRepository<WaterEntity, Integer> {
}
