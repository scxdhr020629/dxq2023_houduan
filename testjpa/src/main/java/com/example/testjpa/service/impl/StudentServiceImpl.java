package com.example.testjpa.service.impl;

import com.example.testjpa.entity.ClazzEntity;
import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.entity.StudentPhysicalEntity;
import com.example.testjpa.exception.EchoServiceException;
import com.example.testjpa.formbean.BeginAndEndDateFormBean;
import com.example.testjpa.formbean.GradeFormBean;
import com.example.testjpa.formbean.QualityFormBean;
import com.example.testjpa.formbean.StudentInfoFormBean;
import com.example.testjpa.repository.ClazzEntityRepository;
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

    @Autowired
    private ClazzEntityRepository clazzEntityRepository;

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

    /**
     * 这一部分目前只获得了第一学期得 需要写一个for循环来将里面得八个学期全部得到
     * @param studentIid
     * @return
     */
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
        List<BeginAndEndDateFormBean> dateList = new ArrayList<>();
        String beginDate1 =year1+"-"+"07"+"-"+"01";
        String endDate1 = year1+"-"+"12"+"-"+"31";
        BeginAndEndDateFormBean temp = new BeginAndEndDateFormBean();
        temp.setBeginDate(beginDate1);
        temp.setEndDate(endDate1);
        dateList.add(temp);
        String beginDate2 = year2+"-"+"01"+"-"+"01";
        String endDate2 =year2+"-"+"06"+"-"+"30";
        // 重新赋值
        temp = new BeginAndEndDateFormBean();
        temp.setBeginDate(beginDate2);
        temp.setEndDate(endDate2);
        dateList.add(temp);

        String beginDate3 =year2+"-"+"07"+"-"+"01";
        String endDate3 = year2+"-"+"12"+"-"+"31";
        temp = new BeginAndEndDateFormBean();
        temp.setBeginDate(beginDate3);
        temp.setEndDate(endDate3);
        dateList.add(temp);
        String beginDate4 = year3+"-"+"01"+"-"+"01";
        String endDate4 =year3+"-"+"06"+"-"+"30";
        temp = new BeginAndEndDateFormBean();
        temp.setBeginDate(beginDate4);
        temp.setEndDate(endDate4);
        dateList.add(temp);

        String beginDate5 =year3+"-"+"07"+"-"+"01";
        String endDate5 = year3+"-"+"12"+"-"+"31";
        temp = new BeginAndEndDateFormBean();
        temp.setBeginDate(beginDate5);
        temp.setEndDate(endDate5);
        dateList.add(temp);
        String beginDate6 = year4+"-"+"01"+"-"+"01";
        String endDate6 =year4+"-"+"06"+"-"+"30";
        temp = new BeginAndEndDateFormBean();
        temp.setBeginDate(beginDate6);
        temp.setEndDate(endDate6);
        dateList.add(temp);
        String beginDate7 =year4+"-"+"07"+"-"+"01";
        String endDate7 = year4+"-"+"12"+"-"+"31";
        temp = new BeginAndEndDateFormBean();
        temp.setBeginDate(beginDate7);
        temp.setEndDate(endDate7);
        dateList.add(temp);
        String beginDate8 = year5+"-"+"01"+"-"+"01";
        String endDate8 =year5+"-"+"06"+"-"+"30";
        temp = new BeginAndEndDateFormBean();
        temp.setBeginDate(beginDate8);
        temp.setEndDate(endDate8);
        dateList.add(temp);

        List<QualityFormBean> finalAns = new ArrayList<>();
        for(int i = 0;i<dateList.size();i++){
            List<Object[]> rawAns =studentEntityRepository.findStudentScholarShipByYear(studentIid,dateList.get(i).getBeginDate(),dateList.get(i).getEndDate());

            QualityFormBean qualityFormBean = new QualityFormBean();
            qualityFormBean.setIid(i+1);
            for(int j=0;j<rawAns.size();j++){
                int grade = qualityFormBean.getGrade();
                grade = grade +Integer.parseInt(rawAns.get(j)[4].toString());

                qualityFormBean.setGrade(grade);
            }

            List<Object[]> rawAns1 = studentEntityRepository.findStudentPunishmentByYear(studentIid,dateList.get(i).getBeginDate(),dateList.get(i).getEndDate());
            for(int j=0;j<rawAns1.size();j++){
                int grade = qualityFormBean.getGrade();
                grade = grade +Integer.parseInt(rawAns1.get(j)[4].toString());

                qualityFormBean.setGrade(grade);
            }




            finalAns.add(qualityFormBean);
        }












        return finalAns;

    }

    @Override
    public List<StudentInfoFormBean> selectStudentAllInfoByUserIid(Integer userIid) {
        List<StudentInfoFormBean> finalAns = new ArrayList<>();
        List<Object[]> oldAns = studentEntityRepository.findStudentByUserIidAllInfo(userIid);
        for(int i=0;i<oldAns.size();i++){
            StudentInfoFormBean studentInfoFormBean = new StudentInfoFormBean();
            studentInfoFormBean.setIid(Integer.parseInt(oldAns.get(i)[0].toString()));
            studentInfoFormBean.setStudentIid(Integer.parseInt(oldAns.get(i)[1].toString()));
            studentInfoFormBean.setUserName(oldAns.get(i)[2].toString());
            studentInfoFormBean.setPassword(oldAns.get(i)[3].toString());
            studentInfoFormBean.setUserRealName(oldAns.get(i)[4].toString());
            studentInfoFormBean.setRole(4);
            studentInfoFormBean.setTelephone(oldAns.get(i)[6].toString());
            studentInfoFormBean.setUserEmail(oldAns.get(i)[7].toString());
            studentInfoFormBean.setSex(oldAns.get(i)[8].toString());
            studentInfoFormBean.setBirthYear(oldAns.get(i)[9].toString());
            studentInfoFormBean.setUserImg(oldAns.get(i)[10].toString());
            studentInfoFormBean.setInYear(Date.valueOf(oldAns.get(i)[11].toString()));
            studentInfoFormBean.setClassIid(Integer.parseInt(oldAns.get(i)[12].toString()));
            studentInfoFormBean.setIsWarned(Integer.parseInt(oldAns.get(i)[13].toString()));
            studentInfoFormBean.setIsHelped(Integer.parseInt(oldAns.get(i)[14].toString()));
            studentInfoFormBean.setAccountMoney(Double.parseDouble(oldAns.get(i)[15].toString()));

            // 对班级的信息进行一个处理
            Integer classIid = studentInfoFormBean.getClassIid();
            ClazzEntity clazzEntity = clazzEntityRepository.findClazzEntityByIid(classIid);
            String clazzName = clazzEntity.getClassName();
            studentInfoFormBean.setClassName(clazzName);

            finalAns.add(studentInfoFormBean);
        }

        return finalAns;
    }
}
