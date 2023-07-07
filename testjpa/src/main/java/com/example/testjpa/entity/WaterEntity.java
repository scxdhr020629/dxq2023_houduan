package com.example.testjpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "map_dormitory_student_water", schema = "dxq", catalog = "")
public class WaterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "dormitory_iid")
    private Integer dormitoryIid;
    @Basic
    @Column(name = "student_iid")
    private Integer studentIid;

    @Basic
    @Column(name = "water_num")
    private Integer waterNum;
    @Basic
    @Column(name = "water_price")
    private Double waterPrice;
    @Basic
    @Column(name = "appeal_date")
    private Date appealDate;
    @Transient
    private String dBuilding;
    @Transient
    private String dNumber;

    public String getDBuilding() {
        return dBuilding;
    }

    public void setDBuilding(String dBuilding) {
        this.dBuilding = dBuilding;
    }

    public String getDNumber() {
        return dNumber;
    }

    public void setDNumber(String dNumber) {
        this.dNumber = dNumber;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public Integer getDormitoryIid() {
        return dormitoryIid;
    }

    public void setDormitoryIid(Integer dormitoryIid) {
        this.dormitoryIid = dormitoryIid;
    }

    public Integer getStudentIid() {
        return studentIid;
    }

    public void setStudentIid(Integer studentIid) {
        this.studentIid = studentIid;
    }

    public Double getWaterPrice() {
        return waterPrice;
    }

    public Integer getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(Integer waterNum) {
        this.waterNum = waterNum;
    }

    public void setWaterPrice(Double waterPrice) {
        this.waterPrice = waterPrice;
    }

    public Date getAppealDate() {
        return appealDate;
    }

    public void setAppealDate(Date appealDate) {
        this.appealDate = appealDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterEntity that = (WaterEntity) o;
        return iid == that.iid && Objects.equals(dormitoryIid, that.dormitoryIid) && Objects.equals(studentIid, that.studentIid) && Objects.equals(waterNum, that.waterNum)&& Objects.equals(waterPrice, that.waterPrice) && Objects.equals(appealDate, that.appealDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, dormitoryIid, studentIid,waterNum, waterPrice, appealDate);
    }
}
