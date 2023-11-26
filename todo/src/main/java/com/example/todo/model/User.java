package com.example.todo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

    @Column(name = "address")
    private String address;

    @Column(name = "salary")
    private Float salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;

    }

    public String getDobStr() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.birthday == null ? null : birthday.format(formatter);
    }

    public String getSalaryStr() {
        return NumberFormat.getNumberInstance(Locale.US).format(this.salary) + " VNĐ";
    }
}
