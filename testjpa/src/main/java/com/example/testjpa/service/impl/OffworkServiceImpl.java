package com.example.testjpa.service.impl;

import com.example.testjpa.entity.OffworkEntity;
import com.example.testjpa.repository.OffworkEntityRepository;
import com.example.testjpa.service.OffworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffworkServiceImpl implements OffworkService {
    private final OffworkEntityRepository offworkRepository;

    @Autowired
    public OffworkServiceImpl(OffworkEntityRepository offworkRepository) {
        this.offworkRepository = offworkRepository;
    }

    @Override
    public List<OffworkEntity> getOffworkByStudentId(Integer studentId) {
        return offworkRepository.findByStudentIid(studentId);
    }

    @Override
    public OffworkEntity addOffwork(OffworkEntity offwork) {
        return offworkRepository.save(offwork);
    }
}
