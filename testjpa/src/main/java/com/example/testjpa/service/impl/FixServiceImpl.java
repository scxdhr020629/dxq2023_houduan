package com.example.testjpa.service.impl;

import com.example.testjpa.entity.FixEntity;
import com.example.testjpa.repository.FixEntityRepository;
import com.example.testjpa.service.FixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixServiceImpl implements FixService {

    private final FixEntityRepository fixEntityRepository;

    @Autowired
    public FixServiceImpl(FixEntityRepository fixEntityRepository) {
        this.fixEntityRepository = fixEntityRepository;
    }

    @Override
    public FixEntity addFix(FixEntity fixEntity) {
        return fixEntityRepository.save(fixEntity);
    }

    @Override
    public void deleteFixByIid(int iid) {
        fixEntityRepository.deleteById(iid);
    }

    @Override
    public List<FixEntity> getFixByStuName(String stuName) {
        return fixEntityRepository.findByStuName(stuName);
    }

}
