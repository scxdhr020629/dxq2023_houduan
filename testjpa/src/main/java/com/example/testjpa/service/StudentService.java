package com.example.testjpa.service;

import com.example.testjpa.entity.StudentEntity;

public interface StudentService {
    //查询学生的相关信息 根据userIid
    public StudentEntity findStudentInfo(Integer userIid);

    // 根据student_iid 来进行查询学生的成绩信息，每一学年的绩点。体测成绩
}
