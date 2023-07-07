package com.example.testjpa.repository;

import com.example.testjpa.entity.FixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixEntityRepository extends JpaRepository<FixEntity, Integer> {
    List<FixEntity> findByStuName(String stuName);
}
