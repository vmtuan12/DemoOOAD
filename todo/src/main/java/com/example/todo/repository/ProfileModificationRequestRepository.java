package com.example.todo.repository;

import com.example.todo.dto.RequestDto;
import com.example.todo.model.ProfileModificationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfileModificationRequestRepository extends JpaRepository<ProfileModificationRequest, Long> {

    @Query(value = """
            SELECT pr.id AS id, pr.title AS title, pr.type AS type, m.name AS receiveUser, pr.content, pr.note,
            pr.request_time AS requestTime, pr.handled_time AS handledTime, pr.status AS status
            FROM profile_modification_request pr JOIN member m on pr.receive_user_id = m.id WHERE pr.id = :id
            """, nativeQuery = true)
    RequestDto getDtoById(Long id);
}
