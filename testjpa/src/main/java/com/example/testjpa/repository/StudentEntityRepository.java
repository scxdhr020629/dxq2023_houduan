package com.example.testjpa.repository;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.formbean.GradeFormBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Integer> {
    public StudentEntity findStudentEntityByUserIid(Integer userIid);
    //写一段原生的sql 语句 三表联合查询成绩
    @Query(value = "select t1.iid,t3.course_name,t3.credit,t1.grade,t2.begin_date from map_student_teacher_course as t1 ,map_teacher_course as t2 , course as t3 where t1.teacher_course__iid = t2.iid and t2.course_iid = t3.iid and student_iid = ?1", nativeQuery = true)
    List<Object[]> findStudentTeacherCourse(Integer studentIid);

    // 写一段原生sql 可以传入年份 查询成绩
    //带学分 和 年的 信息
    @Query(value = "select t1.iid,t3.course_name,t3.credit,t1.grade,t2.begin_date from map_student_teacher_course as t1 ,map_teacher_course as t2 , course as t3 where t1.teacher_course__iid = t2.iid and t2.course_iid = t3.iid and student_iid = ?1 and year(begin_date)=?2", nativeQuery = true)
    List<Object[]> findStudentTeacherCourseByStudentIidAndYear(Integer studentIid,Integer begin_year);

}