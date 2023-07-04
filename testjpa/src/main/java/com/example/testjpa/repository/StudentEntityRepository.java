package com.example.testjpa.repository;

import com.example.testjpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Integer> {
    public StudentEntity findStudentEntityByUserIid(Integer userIid);
}