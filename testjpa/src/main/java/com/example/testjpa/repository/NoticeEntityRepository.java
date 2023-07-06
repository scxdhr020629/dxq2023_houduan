package com.example.testjpa.repository;

import com.example.testjpa.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeEntityRepository extends JpaRepository<NoticeEntity, Integer> {

}