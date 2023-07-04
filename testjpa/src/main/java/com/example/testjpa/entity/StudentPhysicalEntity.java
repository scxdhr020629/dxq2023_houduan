package com.example.testjpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "student_physical", schema = "dxq", catalog = "")
public class StudentPhysicalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "student_iid")
    private Integer studentIid;
    @Basic
    @Column(name = "height")
    private Double height;
    @Basic
    @Column(name = "weight")
    private Double weight;
    @Basic
    @Column(name = "bmi")
    private Double bmi;
    @Basic
    @Column(name = "lung")
    private Double lung;
    @Basic
    @Column(name = "fifty_meter")
    private Double fiftyMeter;
    @Basic
    @Column(name = "sit_reach")
    private Double sitReach;
    @Basic
    @Column(name = "standing_long_jump")
    private Double standingLongJump;
    @Basic
    @Column(name = "eight_hundred_meter")
    private Double eightHundredMeter;
    @Basic
    @Column(name = "sit_up")
    private Double sitUp;
    @Basic
    @Column(name = "phy_grade")
    private Double phyGrade;
    @Basic
    @Column(name = "phy_date")
    private Date phyDate;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public Integer getStudentIid() {
        return studentIid;
    }

    public void setStudentIid(Integer studentIid) {
        this.studentIid = studentIid;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getLung() {
        return lung;
    }

    public void setLung(Double lung) {
        this.lung = lung;
    }

    public Double getFiftyMeter() {
        return fiftyMeter;
    }

    public void setFiftyMeter(Double fiftyMeter) {
        this.fiftyMeter = fiftyMeter;
    }

    public Double getSitReach() {
        return sitReach;
    }

    public void setSitReach(Double sitReach) {
        this.sitReach = sitReach;
    }

    public Double getStandingLongJump() {
        return standingLongJump;
    }

    public void setStandingLongJump(Double standingLongJump) {
        this.standingLongJump = standingLongJump;
    }

    public Double getEightHundredMeter() {
        return eightHundredMeter;
    }

    public void setEightHundredMeter(Double eightHundredMeter) {
        this.eightHundredMeter = eightHundredMeter;
    }

    public Double getSitUp() {
        return sitUp;
    }

    public void setSitUp(Double sitUp) {
        this.sitUp = sitUp;
    }

    public Double getPhyGrade() {
        return phyGrade;
    }

    public void setPhyGrade(Double phyGrade) {
        this.phyGrade = phyGrade;
    }

    public Date getPhyDate() {
        return phyDate;
    }

    public void setPhyDate(Date phyDate) {
        this.phyDate = phyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPhysicalEntity that = (StudentPhysicalEntity) o;
        return iid == that.iid && Objects.equals(studentIid, that.studentIid) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight) && Objects.equals(bmi, that.bmi) && Objects.equals(lung, that.lung) && Objects.equals(fiftyMeter, that.fiftyMeter) && Objects.equals(sitReach, that.sitReach) && Objects.equals(standingLongJump, that.standingLongJump) && Objects.equals(eightHundredMeter, that.eightHundredMeter) && Objects.equals(sitUp, that.sitUp) && Objects.equals(phyGrade, that.phyGrade) && Objects.equals(phyDate, that.phyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, studentIid, height, weight, bmi, lung, fiftyMeter, sitReach, standingLongJump, eightHundredMeter, sitUp, phyGrade, phyDate);
    }
}
