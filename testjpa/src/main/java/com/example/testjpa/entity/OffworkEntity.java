package com.example.testjpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "offwork", schema = "dxq", catalog = "")
public class OffworkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "student_iid")
    private Integer studentIid;
    @Basic
    @Column(name = "begindate")
    private Date beginDate;
    @Basic
    @Column(name = "enddate")
    private Date endDate;
    @Basic
    @Column(name = "applydate")
    private Date applyDate;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "status")
    private String status;

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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffworkEntity that = (OffworkEntity) o;
        return iid == that.iid && Objects.equals(studentIid, that.studentIid) && Objects.equals(beginDate, that.beginDate) && Objects.equals(endDate, that.endDate) && Objects.equals(content, that.content) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, studentIid, beginDate, endDate,applyDate, content, status);
    }
}
