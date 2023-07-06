package com.example.testjpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "dxq", catalog = "")
public class ClazzEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "class_name")
    private String className;
    @Basic
    @Column(name = "counselor_iid")
    private Integer counselorIid;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getCounselorIid() {
        return counselorIid;
    }

    public void setCounselorIid(Integer counselorIid) {
        this.counselorIid = counselorIid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzEntity that = (ClazzEntity) o;
        return iid == that.iid && Objects.equals(className, that.className) && Objects.equals(counselorIid, that.counselorIid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, className, counselorIid);
    }
}
