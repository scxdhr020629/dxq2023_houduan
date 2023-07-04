package com.example.testjpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_info", schema = "dxq", catalog = "")
public class UserInfoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "user_real_name")
    private String userRealName;
    @Basic
    @Column(name = "role")
    private Integer role;
    @Basic
    @Column(name = "telephone")
    private String telephone;
    @Basic
    @Column(name = "user_email")
    private String userEmail;
    @Basic
    @Column(name = "sex")
    private String sex;
    @Basic
    @Column(name = "birth_year")
    private String birthYear;
    @Basic
    @Column(name = "user_img")
    private String userImg;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoEntity that = (UserInfoEntity) o;
        return iid == that.iid && Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(userRealName, that.userRealName) && Objects.equals(role, that.role) && Objects.equals(telephone, that.telephone) && Objects.equals(userEmail, that.userEmail) && Objects.equals(sex, that.sex) && Objects.equals(birthYear, that.birthYear) && Objects.equals(userImg, that.userImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, userName, password, userRealName, role, telephone, userEmail, sex, birthYear, userImg);
    }
}
