package com.example.testjpa.controller;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.entity.StudentPhysicalEntity;
import com.example.testjpa.formbean.*;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * user_iid
     * @param queryExample
     * @return
     */
    @PostMapping("/find-by-user-iid")
    public ResponseData findStudByUserIid(@RequestBody Map<String,String> queryExample){
        StudentEntity studentEntity = studentService.findStudentInfo(Integer.parseInt(queryExample.get("user_iid")));
        if(studentEntity!=null){
            return new ResponseData(ResponseMsg.SUCCESS,studentEntity);
        }
        else{
            return new ResponseData(ResponseMsg.FAILED,null);
        }
    }

    @PostMapping("/find-all-info-by-user-iid")
    public ResponseData findStudentAllInfoByUserIid(@RequestBody Map<String,String> queryExample){
        List<StudentInfoFormBean> ans = studentService.selectStudentAllInfoByUserIid(Integer.parseInt(queryExample.get("user_iid")));
        if(ans.size()!=0){
            return new ResponseData(ResponseMsg.SUCCESS,ans);
        }
        else{
            return new ResponseData(ResponseMsg.FAILED,null);
        }
    }


    /**
     * 查询gpa all
     * @param queryExample
     * @return
     */
    @PostMapping("/select-gpaAll")
    public ResponseData selectGpaALL(@RequestBody Map<String,String> queryExample){
        List<GPAFormBean> ans = studentService.selectGpaByStuIid(Integer.parseInt(queryExample.get("student_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }



    /**
     * 根据学生student_iid 来查询学生的课程成绩
     */

    @PostMapping("/select-grade-by-student-iid")
    public ResponseData selectGradeByStudentIid(@RequestBody Map<String,String> queryExample){
        List<GradeFormBean> ans= studentService.selectStudentGradeByStudentIid(Integer.parseInt(queryExample.get("student_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }

    /**
     * 查询学生成绩 根据 年份 学号
     * @param queryExample
     * @return
     */
    @PostMapping("/select-grade-by-student-iid-and-begin-year")
    public ResponseData selectGradeByStudentIidAndBeginYear(@RequestBody Map<String,String> queryExample){
        List<GradeFormBean> ans= studentService.selectStudentGradeByStudentIidAndYear(Integer.parseInt(queryExample.get("student_iid")),Integer.parseInt(queryExample.get("begin_year")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }


    /**
     * test
     * @param queryExample
     * @return
     */

    @PostMapping("/select-course-by-student-iid-credit-date")
    public ResponseData selectGradeByStudentIidAndCreditAndDate(@RequestBody Map<String,String> queryExample){
        List<CourseFormBean> ans= studentService.selectCourseByStudentIidAndCreditAndYear(Integer.parseInt(queryExample.get("student_iid")),queryExample.get("credit"),queryExample.get("term"));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }

    /**
     * 根据student_iid 来查询学生的体测相关信息
     */
    @PostMapping("/select-physical-grade-by-student-iid")
    public ResponseData selectPhysicalGradeByStudentIid(@RequestBody Map<String,String> queryExample){
        List<StudentPhysicalEntity> ans = studentService.selectStudentPhysicalEntityGrade(Integer.parseInt(queryExample.get("student_iid")));;
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }

    /**
     * student_iid
     * @param queryExample
     * @return
     */
    @PostMapping("/select-student-quality-grade")
    public ResponseData selectStudentQualityGrade(@RequestBody Map<String,String> queryExample){
        List<QualityFormBean> ans = studentService.selectStudentQualityGrade(Integer.parseInt(queryExample.get("student_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }


    /**
     * 查询奖学金 所有
     * @param queryExample
     * @return
     */
    @PostMapping("/select-student-scholarShip-punishment-all")
    public ResponseData selectStudentScholarShip(@RequestBody Map<String,String> queryExample){
        List ans = studentService.selectScholarShipByStudentIid(Integer.parseInt(queryExample.get("student_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }








    @PostMapping("/add-money")
    public ResponseData addStudentMoney(@RequestBody Map<String,String> queryExample){
        Integer ans = studentService.updateStudentMoney(Double.parseDouble(queryExample.get("money")),Integer.parseInt(queryExample.get("student_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }

    /**
     * 查询学生的考试
     * @param queryExample
     * @return
     */
    @PostMapping("/select-examination")
    public ResponseData selectStudentExamination(@RequestBody Map<String,String> queryExample){
        List<ExaminationFormBean> ans = studentService.selectStudentExamination(Integer.parseInt(queryExample.get("student_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }

    /**
     * 查询水电费
     * @param queryExample
     * @return
     */
    @PostMapping("/select-dormitory-water-power-price")
    public ResponseData selectStudentDormitoryWaterAndPowerPrice(@RequestBody Map<String,String> queryExample){
        List<DormitoryWaterAndPowerFormBean> ans = studentService.selectStudentDormitoryWaterAndPower(Integer.parseInt(queryExample.get("student_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }


    @PostMapping("/update-dormitory-water-power-price")
    public ResponseData updateStudentDormitoryWaterAndPowerPrice(@RequestBody Map<String,String> queryExample){
        Integer ans = studentService.updateDormitoryPowerAndWater(Integer.parseInt(queryExample.get("dormitory_water_power_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }

    /**
     * 查询学生宿舍
     * @param queryExample
     * @return
     */
    @PostMapping("/select-dormitory-student-iid")
    public ResponseData selectDormitoryByStudentIid(@RequestBody Map<String,String> queryExample){
        List<DormitoryFormBean> ans = studentService.selectDormitoryByStuIid(Integer.parseInt(queryExample.get("student_iid")));
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }





}
