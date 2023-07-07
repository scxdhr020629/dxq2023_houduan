package com.example.testjpa.service;

import com.example.testjpa.entity.OffworkEntity;

import java.util.List;

public interface OffworkService {
    List<OffworkEntity> getOffworkByStudentId(Integer studentId);
    OffworkEntity addOffwork(OffworkEntity offwork);
    void deleteOffworkByIid(int iid);

}
