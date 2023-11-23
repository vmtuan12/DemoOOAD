package com.example.todo.repository;

import com.example.todo.model.EmployeePerformance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePerformanceRepository extends JpaRepository<EmployeePerformance, Long> {
}
