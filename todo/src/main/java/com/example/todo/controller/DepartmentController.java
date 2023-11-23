package com.example.todo.controller;

import com.example.todo.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
}
