package com.example.testjpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "dxq", catalog = "")
public class StudentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "user_iid")
    private Integer userIid;
    @Basic
    @Column(name = "in_year")
    private Date inYear;
    @Basic
    @Column(name = "class_iid")
    private Integer classIid;
    @Basic
    @Column(name = "is_warned")
    private Integer isWarned;
    @Basic
    @Column(name = "is_helped")
    private Integer isHelped;
    @Basic
    @Column(name = "account_money")
    private Double accountMoney;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public Integer getUserIid() {
        return userIid;
    }

    public void setUserIid(Integer userIid) {
        this.userIid = userIid;
    }

    public Date getInYear() {
        return inYear;
    }

    public void setInYear(Date inYear) {
        this.inYear = inYear;
    }

    public Integer getClassIid() {
        return classIid;
    }

    public void setClassIid(Integer classIid) {
        this.classIid = classIid;
    }

    public Integer getIsWarned() {
        return isWarned;
    }

    public void setIsWarned(Integer isWarned) {
        this.isWarned = isWarned;
    }

    public Integer getIsHelped() {
        return isHelped;
    }

    public void setIsHelped(Integer isHelped) {
        this.isHelped = isHelped;
    }

    public Double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Double accountMoney) {
        this.accountMoney = accountMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return iid == that.iid && Objects.equals(userIid, that.userIid) && Objects.equals(inYear, that.inYear) && Objects.equals(classIid, that.classIid) && Objects.equals(isWarned, that.isWarned) && Objects.equals(isHelped, that.isHelped) && Objects.equals(accountMoney, that.accountMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, userIid, inYear, classIid, isWarned, isHelped, accountMoney);
    }
}
