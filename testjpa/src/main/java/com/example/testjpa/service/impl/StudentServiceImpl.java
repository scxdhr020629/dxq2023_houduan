package com.example.testjpa.service.impl;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.formbean.GradeFormBean;
import com.example.testjpa.repository.StudentEntityRepository;
import com.example.testjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentEntityRepository studentEntityRepository;

    @Override
    public StudentEntity findStudentInfo(Integer userIid) {
        StudentEntity studentEntity = studentEntityRepository.findStudentEntityByUserIid(userIid);
        return studentEntity;
    }

    @Override
    public List<Object[]> selectStudentGradeByStudentIid(Integer studentIid) {

        List<Object[]> ans = studentEntityRepository.findStudentTeacherCourse(studentIid);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).length;j++){
                System.out.println(ans.get(i)[j]);
            }
        }

        return ans;

    }
}
