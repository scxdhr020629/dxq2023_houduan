package com.example.testjpa.repository;

import com.example.testjpa.entity.ClazzEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClazzEntityRepository extends JpaRepository<ClazzEntity, Integer> {
    public ClazzEntity findClazzEntityByIid(Integer iid);
}