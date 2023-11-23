package com.example.todo.service;

import com.example.todo.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
}
