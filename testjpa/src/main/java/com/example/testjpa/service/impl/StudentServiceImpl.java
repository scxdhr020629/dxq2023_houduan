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

import java.sql.Date;
import java.util.ArrayList;
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
    public List<GradeFormBean> selectStudentGradeByStudentIid(Integer studentIid) {

        List<Object[]> ans = studentEntityRepository.findStudentTeacherCourse(studentIid);
        List<GradeFormBean> newAns = new ArrayList<>();
        // 对查询出来的数据做一个格式的处理
        for(int i=0;i<ans.size();i++){
            GradeFormBean gradeFormBean = new GradeFormBean();
            gradeFormBean.setIid((Integer) ans.get(i)[0]);
            gradeFormBean.setCourseName( ans.get(i)[1].toString());
            gradeFormBean.setCredit(Double.parseDouble(ans.get(i)[2].toString()));
            gradeFormBean.setGrade(Double.parseDouble(ans.get(i)[3].toString()));
            gradeFormBean.setBeginDate(Date.valueOf(ans.get(i)[4].toString()));
            newAns.add(gradeFormBean);
        }
        return newAns;

    }

    @Override
    public List<GradeFormBean> selectStudentGradeByStudentIidAndYear(Integer studentIid, Integer begin_year) {
        List<Object[]> ans = studentEntityRepository.findStudentTeacherCourseByStudentIidAndYear(studentIid,begin_year);
        List<GradeFormBean> newAns = new ArrayList<>();
        // 对查询出来的数据做一个格式的处理
        for(int i=0;i<ans.size();i++){
            GradeFormBean gradeFormBean = new GradeFormBean();
            gradeFormBean.setIid((Integer) ans.get(i)[0]);
            gradeFormBean.setCourseName( ans.get(i)[1].toString());
            gradeFormBean.setCredit(Double.parseDouble(ans.get(i)[2].toString()));
            gradeFormBean.setGrade(Double.parseDouble(ans.get(i)[3].toString()));
            gradeFormBean.setBeginDate(Date.valueOf(ans.get(i)[4].toString()));
            newAns.add(gradeFormBean);
        }
        return newAns;
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
