package com.example.testjpa.repository;

import com.example.testjpa.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoEntityRepository extends JpaRepository<UserInfoEntity, Integer> {
    public UserInfoEntity findUserInfoEntityByUserNameAndAndPassword(String userName,String password);
}