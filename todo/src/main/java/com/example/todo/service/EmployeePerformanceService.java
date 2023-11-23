package com.example.todo.service;

import com.example.todo.repository.EmployeePerformanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeePerformanceService {

    @Autowired
    EmployeePerformanceRepository employeePerformanceRepository;
}
