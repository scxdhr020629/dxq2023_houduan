package com.example.testjpa.service.impl;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.entity.StudentPhysicalEntity;
import com.example.testjpa.exception.EchoServiceException;
import com.example.testjpa.formbean.GradeFormBean;
import com.example.testjpa.formbean.QualityFormBean;
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

    @Override
    public List<QualityFormBean> selectStudentQualityGrade(Integer studentIid) {
        StudentEntity studentEntity = studentEntityRepository.findStudentEntityByIid(studentIid);
        Date inYear = studentEntity.getInYear();

        int year =inYear.toLocalDate().getYear();
        // 2020
        int year1 = year;
        // 2021
        int year2 = year1+1;
        // 2022
        int year3 = year2+1;
        // 2023
        int year4 = year3+1;
        //2024
        int year5 = year4+1;

        String beginDate1 =year1+"-"+"07"+"-"+"01";
        String endDate1 = year1+"-"+"12"+"-"+"31";
        String beginDate2 = year2+"-"+"01"+"-"+"01";
        String endDate2 =year2+"-"+"06"+"-"+"30";


        String beginDate3 =year2+"-"+"07"+"-"+"01";
        String endDate3 = year2+"-"+"12"+"-"+"31";
        String beginDate4 = year3+"-"+"01"+"-"+"01";
        String endDate4 =year3+"-"+"06"+"-"+"30";

        String beginDate5 =year3+"-"+"07"+"-"+"01";
        String endDate5 = year3+"-"+"12"+"-"+"31";
        String beginDate6 = year4+"-"+"01"+"-"+"01";
        String endDate6 =year4+"-"+"06"+"-"+"30";

        String beginDate7 =year4+"-"+"07"+"-"+"01";
        String endDate7 = year4+"-"+"12"+"-"+"31";
        String beginDate8 = year5+"-"+"01"+"-"+"01";
        String endDate8 =year5+"-"+"06"+"-"+"30";


        System.out.println(beginDate1);
        System.out.println(endDate8);

        List<QualityFormBean> finalAns = new ArrayList<>();

        List<Object[]> rawAns1 =studentEntityRepository.findStudentScholarShipByYear(studentIid,beginDate1,endDate1);
        QualityFormBean qualityFormBean = new QualityFormBean();
        qualityFormBean.setIid(1);
        qualityFormBean.setPeriod("第一学期");
        for(int i =0;i<rawAns1.size();i++){
            int grade = qualityFormBean.getGrade();

            grade = grade +Integer.parseInt(rawAns1.get(i)[4].toString());
            System.out.println(grade);
            qualityFormBean.setGrade(grade);

        }
        finalAns.add(qualityFormBean);



        return finalAns;

    }
}
