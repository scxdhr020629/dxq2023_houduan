package com.example.testjpa.service;

import com.example.testjpa.entity.FixEntity;

import java.util.List;

public interface FixService {
    FixEntity addFix(FixEntity fixEntity);
    void deleteFixByIid(int iid);

    List<FixEntity> getFixByStuName(String stuName);
}
