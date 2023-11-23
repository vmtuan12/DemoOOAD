package com.example.todo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -197553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "department_id")
    private Long departmentId;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;

    }
}
