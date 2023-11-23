package com.example.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employee_performance")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePerformance implements Serializable {

    private static final long serialVersionUID = -197553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "hr_id")
    private Long hrId;

    @Column(name = "performance_score")
    private Float performanceScore;

    @Column(name = "comment")
    private String comment;

    @Column(name = "evaluate_time")
    private LocalDateTime evaluateTime;
}
