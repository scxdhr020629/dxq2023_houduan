package com.example.testjpa.controller;

import com.example.testjpa.entity.NoticeEntity;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public List<NoticeEntity> getAllNotices() {
        return noticeService.getAllNotices();
    }

    // 根据iid参数获取通知项信息
    @GetMapping("/{iid}")
    public NoticeEntity getNoticeById(@PathVariable int iid) {
        return noticeService.getNoticeById(iid);
    }
}
