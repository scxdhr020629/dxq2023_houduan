package com.example.testjpa.controller;

import com.example.testjpa.entity.UserInfoEntity;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @PostMapping("/find-all")
    public ResponseData findAll() {
        List<UserInfoEntity> ans = userInfoService.findAll();
        return new ResponseData(ResponseMsg.SUCCESS, ans);
    }


    @PostMapping("/delete-by-iid")
    public ResponseData deleteByIid(@RequestBody Map<String,String> queryExample){
       userInfoService.deleteUserByIid(Integer.parseInt(queryExample.get("iid")));
       return new ResponseData(ResponseMsg.SUCCESS,"删除成功");
    }

    /**
     *
     * @param queryExample
     * username
     * password
     * @return
     */
    @PostMapping("/find-by-username-password")
    public ResponseData findByUserNameAndPassword(@RequestBody Map<String,String> queryExample){
        UserInfoEntity ans= userInfoService.findUserByUserNameAndPassword(queryExample.get("username"), queryExample.get("password") );
        if(ans==null){
            return new ResponseData(ResponseMsg.FAILED, null);
        }
        else{
            return new ResponseData(ResponseMsg.SUCCESS, ans);
        }
    }

}
