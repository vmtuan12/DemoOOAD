package com.example.todo.repository;

import com.example.todo.model.ProfileModificationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileModificationRequestRepository extends JpaRepository<ProfileModificationRequest, Long> {
}
