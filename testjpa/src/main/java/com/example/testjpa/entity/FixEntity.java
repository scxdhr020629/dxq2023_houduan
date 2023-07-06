package com.example.testjpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fix_apply", schema = "dxq", catalog = "")
public class FixEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "stu_name")
    private String stuName;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "d_buiding")
    private String dBuiding;
    @Basic
    @Column(name = "d_number")
    private String dNumber;
    @Basic
    @Column(name = "fix_content")
    private String fixContent;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDBuiding() {
        return dBuiding;
    }

    public void setDBuiding(String dBuiding) {
        this.dBuiding = dBuiding;
    }

    public String getDNumber() {
        return dNumber;
    }

    public void setDNumber(String dNumber) {
        this.dNumber = dNumber;
    }

    public String getFixContent() {
        return fixContent;
    }

    public void setFixContent(String fixContent) {
        this.fixContent = fixContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixEntity fixEntity = (FixEntity) o;
        return iid == fixEntity.iid && Objects.equals(stuName, fixEntity.stuName) && Objects.equals(phone, fixEntity.phone) && Objects.equals(dBuiding, fixEntity.dBuiding) && Objects.equals(dNumber, fixEntity.dNumber) && Objects.equals(fixContent, fixEntity.fixContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, stuName, phone, dBuiding, dNumber, fixContent);
    }
}
