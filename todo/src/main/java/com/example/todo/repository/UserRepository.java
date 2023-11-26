package com.example.todo.repository;

import com.example.todo.dto.BaseMemberDto;
import com.example.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u.id FROM User u WHERE u.username = :name")
    Integer findUserIdByName(@Param("name") String name);

    List<User> findAll();
    Optional<User> findByUsername(String username);

    User findById(Long id);

    @Query("SELECT d.headId FROM User u JOIN Department d WHERE u.id = :id")
    Long findHeadOfDepartmentId(Long id);

    @Query(value = "SELECT u.id FROM member u WHERE u.role = 'HR' LIMIT 1", nativeQuery = true)
    Long findHrId();

    @Query("SELECT u.password FROM User u WHERE u.id = :id")
    String getPasswordById(@Param("id") Integer id);

    @Query(value = """
            SELECT m.name AS name, m.role AS role, IF(d.department_name IS NULL, 'N/a', d.department_name) AS department, IF(m.id = d.head_id, 1, 0) AS isHead
            FROM member m LEFT JOIN department d on d.id = m.department_id
            """, nativeQuery = true)
    List<BaseMemberDto> findAllMember();
}
