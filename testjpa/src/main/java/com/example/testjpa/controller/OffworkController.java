package com.example.testjpa.controller;
import com.example.testjpa.entity.OffworkEntity;
import com.example.testjpa.service.OffworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/offwork")
public class OffworkController {
    private final OffworkService offworkService;

    @Autowired
    public OffworkController(OffworkService offworkService) {
        this.offworkService = offworkService;
    }

    @PostMapping("/student/{id}")
    public List<OffworkEntity> getOffworkByStudentId(@PathVariable("id") Integer studentId) {
        return offworkService.getOffworkByStudentId(studentId);
    }

    @PostMapping("/add")
    public OffworkEntity addOffwork(@RequestBody OffworkEntity offwork) {
        return offworkService.addOffwork(offwork);
    }
}
