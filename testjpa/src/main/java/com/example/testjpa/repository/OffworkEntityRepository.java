package com.example.testjpa.repository;

import com.example.testjpa.entity.OffworkEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OffworkEntityRepository extends CrudRepository<OffworkEntity, Integer> {
    List<OffworkEntity> findByStudentIid(Integer studentIid);
}

