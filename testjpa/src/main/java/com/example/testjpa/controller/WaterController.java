package com.example.testjpa.controller;

import com.example.testjpa.entity.WaterEntity;
import com.example.testjpa.result.Response;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @PostMapping("/add")
    public ResponseData AddWater(@RequestParam ("dormitory_iid") Integer dormitory_iid,
                                 @RequestParam ("student_iid") Integer student_iid,
                                 @RequestParam ("num") Integer num
                                 ){
        WaterEntity waterEntity = new WaterEntity();
        waterEntity.setDormitoryIid(dormitory_iid);
        waterEntity.setStudentIid(student_iid);
        waterEntity.setWaterNum(num);
        waterEntity.setWaterPrice(11.0);
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        waterEntity.setAppealDate(sqlDate);

        waterService.AddWater(waterEntity);

        return new ResponseData(ResponseMsg.SUCCESS);
    }

}
