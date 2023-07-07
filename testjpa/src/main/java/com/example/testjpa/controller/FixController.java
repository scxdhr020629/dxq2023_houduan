package com.example.testjpa.controller;

import com.example.testjpa.entity.FixEntity;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.FixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/fixes")
public class FixController {

    private final FixService fixService;

    @Autowired
    public FixController(FixService fixService) {
        this.fixService = fixService;
    }

    @PostMapping("/add")
    public ResponseData addFix(@RequestBody FixEntity fixEntity) {
        fixService.addFix(fixEntity);
        return new ResponseData(ResponseMsg.SUCCESS,"添加成功");
    }
    @PostMapping("/delete")
    public ResponseData deleteFixByIid(@RequestBody Map<String,Integer> queryExample) {
        fixService.deleteFixByIid(queryExample.get("iid"));
        return new ResponseData(ResponseMsg.SUCCESS,"删除成功");

    }

    @PostMapping("/listbyStuName")
    public ResponseData getFixByStuName(@RequestBody Map<String,String> queryExample) {
        return new ResponseData(ResponseMsg.SUCCESS,fixService.getFixByStuName(queryExample.get("StuName")));
    }
}
