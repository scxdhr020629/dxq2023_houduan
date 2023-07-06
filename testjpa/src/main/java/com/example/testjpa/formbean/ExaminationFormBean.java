package com.example.testjpa.formbean;

import lombok.Data;

import java.sql.Date;

@Data
public class ExaminationFormBean {
    Integer iid;
    Integer teacherCourseIid;
    String courseName;
    Date examDate;
    String location;
    Integer seat;
}
