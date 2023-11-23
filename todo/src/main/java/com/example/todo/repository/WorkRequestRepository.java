package com.example.todo.repository;

import com.example.todo.model.WorkRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRequestRepository extends JpaRepository<WorkRequest, Long> {
}
