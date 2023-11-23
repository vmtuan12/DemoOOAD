package com.example.todo.repository;

import com.example.todo.model.FixedSalaryChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedSalaryChangeRequestRepository extends JpaRepository<FixedSalaryChangeRequest, Long> {
}
