package com.example.testjpa.controller;

import com.example.testjpa.entity.FixEntity;
import com.example.testjpa.service.FixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class FixController {

    private final FixService fixService;

    @Autowired
    public FixController(FixService fixService) {
        this.fixService = fixService;
    }

    @PostMapping("/fixes/add")
    public FixEntity addFix(@RequestBody FixEntity fixEntity) {
        return fixService.addFix(fixEntity);
    }
}
