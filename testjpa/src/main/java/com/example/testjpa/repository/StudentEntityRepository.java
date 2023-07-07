package com.example.testjpa.repository;

import com.example.testjpa.entity.StudentEntity;
import com.example.testjpa.formbean.GradeFormBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
    // 查询 素质分 奖励部分
    @Query(value = "select t1.iid,t1.student_iid,t1.get_date,t2.amount,t2.addpoint from map_student_scholarship as t1,scholarship as t2 where t1.scholarship_iid = t2.iid and  student_iid = ?1 and  get_date>=?2 and get_date <= ?3 ", nativeQuery = true)
    List<Object[]> findStudentScholarShipByYear(Integer studentIid,String beginYear,String endYear);

    // 查询素质分 惩罚部分
    @Query(value = "select t1.iid,t1.student_iid,t1.get_date,t2.punishment_name,t2.decpoint from map_student_punishment as t1,punishment as t2 where t1.punishment_iid = t2.iid and  student_iid = ?1 and  get_date>=?2 and get_date <= ?3", nativeQuery = true)
    List<Object[]> findStudentPunishmentByYear(Integer studentIid,String beginYear,String endYear);


//    StudentEntity findStudentEntityByIid(Integer iid);
    // 根据student iid 来进行
    StudentEntity findStudentEntityByIid(Integer iid);


    // user_iid来查询
    @Query(value = "select t1.iid,t2.iid as student_iid,t1.user_name,t1.password,t1.user_real_name,t1.role,t1.telephone,t1.user_email,t1.sex,t1.birth_year,t1.user_img,t2.in_year,t2.class_iid,t2.is_warned,t2.is_helped,t2.account_money from user_info as t1,student as t2 where t1.iid = t2.user_iid  and t1.iid =?1", nativeQuery = true)
    List<Object[]> findStudentByUserIidAllInfo(Integer iid);


    // 不一定可行 因为 前面 有一个加号
    @Modifying
    @Transactional
    @Query(value = "update student set account_money = account_money+ ?1 where iid = ?2", nativeQuery = true)
    void addStudentMoney(Double money,Integer iid);


    //更改缴费状态
    @Modifying
    @Transactional
    @Query(value = "update dormitory_power_water set `status` = '已缴费' where iid = ?1", nativeQuery = true)
    void updateDormitoryWaterAndPower(Integer dormitoryWaterAndPowerIid);





    @Query(value = "SELECT\n" +
            "\tt1.iid,\n" +
            "\tt1.teacher_course_iid,\n" +
            "\tt3.course_name,\n" +
            "\tt1.exam_date ,\n" +
            "\tt1.location,\n" +
            "\tt1.seat\n" +
            "\t\n" +
            "\n" +
            "FROM\n" +
            "\texamination AS t1,\n" +
            "\tmap_teacher_course AS t2,\n" +
            "\tcourse AS t3 \n" +
            "\n" +
            "WHERE\n" +
            "\tt1.exam_date > CURDATE() \n" +
            "\tAND t1.teacher_course_iid = t2.iid \n" +
            "\tAND t2.course_iid = t3.iid\n", nativeQuery = true)
    public List<Object[]> findExamInfo();

    @Query(value = "select teacher_course__iid from map_student_teacher_course where student_iid = ?1", nativeQuery = true)
    public List<Object[]> selectStudentCourseByStudentIid(Integer iid);


    //写一个学生 住宿费所有信息的查询 传入student_iid即可
    @Query(value = "select t2.iid,t1.dormitory_iid,t3.d_buiding,t3.d_number,t2.power_price,t2.used_water_price,t2.begin_date,t2.end_date,t2.`status` from map_dormitory_student as t1,dormitory_power_water as t2 ,dormitory as t3\n" +
            "\n" +
            "where t1.dormitory_iid= t2.dormitory_iid\n" +
            "and t1.dormitory_iid = t3.iid\n" +
            "and t1.student_iid = ?1", nativeQuery = true)
    public List<Object[]> selectStudentDormitoryWaterAndPower(Integer studentIid);



    // 根据学生iid 查询宿舍信息
    @Query(value = "select t1.iid,t1.d_buiding,t1.d_number from dormitory as t1, map_dormitory_student as t2 where t1.iid = t2.dormitory_iid and t2.student_iid = ?1", nativeQuery = true)
    public List<Object[]> selectDormitoryByStudentIid(Integer iid);
}