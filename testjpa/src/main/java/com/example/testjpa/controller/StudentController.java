package com.example.testjpa.controller;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
