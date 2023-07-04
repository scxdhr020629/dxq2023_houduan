package com.example.testjpa.service.impl;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.entity.StudentPhysicalEntity;
import com.example.testjpa.exception.EchoServiceException;
import com.example.testjpa.formbean.GradeFormBean;
import com.example.testjpa.repository.StudentEntityRepository;
import com.example.testjpa.repository.StudentPhysicalEntityRepository;
import com.example.testjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    // 学生实体信息表
    @Autowired
    private StudentEntityRepository studentEntityRepository;
    // 放学生的体测信息的表
    @Autowired
    private StudentPhysicalEntityRepository studentPhysicalEntityRepository;
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

    @Override
    public List<StudentPhysicalEntity> selectStudentPhysicalEntityGrade(Integer studentIid) {
        List<StudentPhysicalEntity> studentPhysicalEntities = null;
        try{
            studentPhysicalEntities = studentPhysicalEntityRepository.findStudentPhysicalEntitiesByStudentIid(studentIid);
        }catch (Exception e){
            throw new EchoServiceException("查询学生体测信息时出错");
        }
        return studentPhysicalEntities;
    }
}
