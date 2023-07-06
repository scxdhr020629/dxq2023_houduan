package com.example.testjpa.controller;

import com.example.testjpa.entity.NoticeEntity;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping("/find-all")
    public ResponseData findAllNotice(){
        List<NoticeEntity> rawAns = noticeService.findAllNotice();
        return new ResponseData(ResponseMsg.SUCCESS,rawAns);
    }
}
