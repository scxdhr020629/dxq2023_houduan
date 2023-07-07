package com.example.testjpa.service;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.entity.StudentPhysicalEntity;
import com.example.testjpa.formbean.*;

import java.util.List;

public interface StudentService {
    //查询学生的相关信息 根据userIid
    public StudentEntity findStudentInfo(Integer userIid);

    // 根据student_iid 来进行查询学生的成绩信息
    public List<GradeFormBean> selectStudentGradeByStudentIid(Integer studentIid);

    public List<GradeFormBean> selectStudentGradeByStudentIidAndYear(Integer studentIid,Integer begin_year);



    public List<StudentPhysicalEntity> selectStudentPhysicalEntityGrade(Integer studentIid);

    public List<QualityFormBean> selectStudentQualityGrade(Integer studentIid);

    public List<StudentInfoFormBean> selectStudentAllInfoByUserIid(Integer userIid);


    // 学生卡部分
    public Integer updateStudentMoney(Double addMoney,Integer iid);

    // 查询学生考试
    public List<ExaminationFormBean> selectStudentExamination(Integer studentIid);

    public List<DormitoryWaterAndPowerFormBean> selectStudentDormitoryWaterAndPower(Integer studentIid);


    public Integer updateDormitoryPowerAndWater(Integer dormitoryPowerAndPriceIid);


}
