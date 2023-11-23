package com.example.todo.repository;

import com.example.todo.model.DraftEmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DraftEmployeeProfileRepository extends JpaRepository<DraftEmployeeProfile, Long> {
}
