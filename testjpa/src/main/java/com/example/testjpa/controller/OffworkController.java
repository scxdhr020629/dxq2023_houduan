package com.example.testjpa.controller;
import com.example.testjpa.entity.OffworkEntity;
import com.example.testjpa.entity.WaterEntity;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.OffworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/offwork")
public class OffworkController {
    private final OffworkService offworkService;

    @Autowired
    public OffworkController(OffworkService offworkService) {
        this.offworkService = offworkService;
    }

    @PostMapping("/student")
    public ResponseData getOffworkByStudentId(@RequestBody Map<String,Integer> queryExample) {
        return new ResponseData(ResponseMsg.SUCCESS,offworkService.getOffworkByStudentId(queryExample.get("StudentId")));
    }
    @PostMapping("/delete")
    public ResponseData deleteOffworkByIid(@RequestBody Map<String,Integer> queryExample) {
        offworkService.deleteOffworkByIid(queryExample.get("iid"));
        return new ResponseData(ResponseMsg.SUCCESS,"删除成功");
    }
    @PostMapping("/add")
    public ResponseData addOffwork(@RequestBody Map<String,String> queryExample) {
        OffworkEntity offworkEntity = new OffworkEntity();
        offworkEntity.setStudentIid(Integer.valueOf(queryExample.get("studentIid")));
        offworkEntity.setBeginDate(Date.valueOf(queryExample.get("beginDate")));
        offworkEntity.setEndDate(Date.valueOf(queryExample.get("endDate")));
        offworkEntity.setContent(queryExample.get("content"));
        offworkEntity.setStatus("待审核");

        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        offworkEntity.setApplyDate(sqlDate);
        offworkService.addOffwork(offworkEntity);
        return new ResponseData(ResponseMsg.SUCCESS,"添加成功");
    }

}
