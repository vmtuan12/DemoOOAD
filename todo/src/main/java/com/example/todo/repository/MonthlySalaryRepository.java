package com.example.todo.repository;

import com.example.todo.model.MonthlySalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlySalaryRepository extends JpaRepository<MonthlySalary, Long> {
}
