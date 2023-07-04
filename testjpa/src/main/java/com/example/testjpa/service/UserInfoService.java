package com.example.testjpa.service;

import com.example.testjpa.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {
    public List<UserInfoEntity> findAll();

    public Integer deleteUserByIid(Integer iid);

    public UserInfoEntity findUserByUserNameAndPassword(String userName,String password);


    //传递一个user信息，能够查到学生所有的相关信息


}
