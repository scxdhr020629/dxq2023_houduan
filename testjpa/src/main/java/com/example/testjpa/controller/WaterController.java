package com.example.testjpa.controller;

import com.example.testjpa.entity.WaterEntity;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @PostMapping("/find")
    public ResponseData findAll(){
        return new ResponseData(ResponseMsg.SUCCESS,waterService.findAll());
    }

    @PostMapping("/add")
    public ResponseData AddWater(@RequestBody Map<String,Integer> queryExample){
        WaterEntity waterEntity = new WaterEntity();
        waterEntity.setDormitoryIid(queryExample.get("dormitoryIid"));
        waterEntity.setStudentIid(queryExample.get("studentIid"));
        waterEntity.setWaterNum(queryExample.get("num"));
        waterEntity.setWaterPrice(11.0);
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        waterEntity.setAppealDate(sqlDate);
        waterService.AddWater(waterEntity);

        return new ResponseData(ResponseMsg.SUCCESS);
    }

}
