package com.example.testjpa.formbean;

import javax.persistence.criteria.CriteriaBuilder;

public class QualityFormBean {

    Integer iid;
//    String period;
    //这里就直接iid了
    int grade;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

//    public String getPeriod() {
//        return period;
//    }
//
//    public void setPeriod(String period) {
//        this.period = period;
//    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
