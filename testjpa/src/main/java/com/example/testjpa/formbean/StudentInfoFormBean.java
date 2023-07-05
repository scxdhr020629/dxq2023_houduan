package com.example.testjpa.formbean;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * 还不知道这个formbean要怎么用
 */
@Data
public class StudentInfoFormBean {

   Integer iid;
   Integer studentIid;
   String userName;
   String password;
   String userRealName;
   Integer role;
   String telephone;
   String userEmail;
   String sex;
   String birthYear;
   String userImg;
   Date inYear;
   Integer classIid;
   Integer isWarned;
   Integer isHelped;
   Double accountMoney;
//   Double qualityGrade;



}
