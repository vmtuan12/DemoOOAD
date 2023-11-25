package com.example.todo.repository;

import com.example.todo.dto.RequestDto;
import com.example.todo.model.PersonalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalRequestRepository extends JpaRepository<PersonalRequest, Long> {

    @Query(value = """
            (SELECT pr.id AS id, pr.title AS title, pr.type AS type, m.name AS receiveUser, pr.request_time AS requestTime, pr.status AS status
            FROM personal_request pr JOIN member m on pr.receive_user_id = m.id WHERE pr.sent_user_id = :userId
            UNION
            SELECT pr.id AS id, pr.title AS title, pr.type AS type, m.name AS receiveUser, pr.request_time AS requestTime, pr.status AS status
            FROM work_request pr JOIN member m on pr.receive_user_id = m.id WHERE pr.sent_user_id = :userId
            UNION
            SELECT pr.id AS id, pr.title AS title, pr.type AS type, m.name AS receiveUser, pr.request_time AS requestTime, pr.status AS status
            FROM re_evaluate_request pr JOIN member m on pr.receive_user_id = m.id WHERE pr.sent_user_id = :userId
            UNION
            SELECT pr.id AS id, pr.title AS title, pr.type AS type, m.name AS receiveUser, pr.request_time AS requestTime, pr.status AS status
            FROM fixed_salary_change_request pr JOIN member m on pr.receive_user_id = m.id WHERE pr.sent_user_id = :userId
            UNION
            SELECT pr.id AS id, pr.title AS title, pr.type AS type, m.name AS receiveUser, pr.request_time AS requestTime, pr.status AS status
            FROM monthly_salary_complain_request pr JOIN member m on pr.receive_user_id = m.id WHERE pr.sent_user_id = :userId
            UNION
            SELECT pr.id AS id, pr.title AS title, pr.type AS type, m.name AS receiveUser, pr.request_time AS requestTime, pr.status AS status
            FROM profile_modification_request pr JOIN member m on pr.receive_user_id = m.id WHERE pr.sent_user_id = :userId)
            ORDER BY requestTime DESC
            """, nativeQuery = true)
    List<RequestDto> getAllRequestsBySentUserId(Long userId);

    @Query(value = """
            SELECT pr.id AS id, pr.title AS title, pr.type AS type, m.name AS receiveUser, pr.content, pr.note,
            pr.request_time AS requestTime, pr.handled_time AS handledTime, pr.status AS status
            FROM personal_request pr JOIN member m on pr.receive_user_id = m.id WHERE pr.id = :id
            """, nativeQuery = true)
    RequestDto getDtoById(Long id);
}
