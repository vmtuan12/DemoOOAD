package com.example.todo.repository;

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

    @Query("SELECT u.password FROM User u WHERE u.id = :id")
    String getPasswordById(@Param("id") Integer id);
}
