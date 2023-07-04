package com.example.testjpa.repository;

import com.example.testjpa.entity.StudentPhysicalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentPhysicalEntityRepository extends JpaRepository<StudentPhysicalEntity, Integer> {
    // 全部信息的查询
    List<StudentPhysicalEntity> findStudentPhysicalEntitiesByStudentIid(Integer studentIid);
}