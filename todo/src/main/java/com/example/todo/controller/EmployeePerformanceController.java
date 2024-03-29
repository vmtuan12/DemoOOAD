package com.example.todo.controller;

import com.example.todo.service.EmployeePerformanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance")
@AllArgsConstructor
public class EmployeePerformanceController {

    @Autowired
    EmployeePerformanceService employeePerformanceService;
}
