package com.example.testjpa.controller;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.entity.StudentPhysicalEntity;
import com.example.testjpa.formbean.GradeFormBean;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
     * 根据student_iid 来查询学生的体测相关信息
     */
    @PostMapping("/select-physical-grade-by-student-iid")
    public ResponseData selectPhysicalGradeByStudentIid(@RequestBody Map<String,String> queryExample){
        List<StudentPhysicalEntity> ans = studentService.selectStudentPhysicalEntityGrade(Integer.parseInt(queryExample.get("student_iid")));;
        return new ResponseData(ResponseMsg.SUCCESS,ans);
    }
}
