package com.example.todo.repository;

import com.example.todo.model.PersonalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRequestRepository extends JpaRepository<PersonalRequest, Long> {
}
