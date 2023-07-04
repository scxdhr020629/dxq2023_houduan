package com.example.testjpa.service.impl;

import com.example.testjpa.entity.UserInfoEntity;
import com.example.testjpa.exception.EchoServiceException;
import com.example.testjpa.repository.UserInfoEntityRepository;
import com.example.testjpa.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoEntityRepository userInfoEntityRepository;

    @Override
    public List<UserInfoEntity> findAll() {

        List<UserInfoEntity> ans = userInfoEntityRepository.findAll();
        if(ans.size()<=0){
            throw new EchoServiceException("没有案例");
        }
        else{
            return ans;
        }
    }

    @Override
    public Integer deleteUserByIid(Integer iid) {
        int myFlag = 1;
        try{
            userInfoEntityRepository.deleteById(iid);

        }catch (Exception e){
            throw new EchoServiceException("删除出现问题");

        }
        return myFlag;
    }

    @Override
    public UserInfoEntity findUserByUserNameAndPassword(String userName, String password) {
        UserInfoEntity userInfoEntity = userInfoEntityRepository.findUserInfoEntityByUserNameAndAndPassword(userName,password);
        return  userInfoEntity;
    }






}
