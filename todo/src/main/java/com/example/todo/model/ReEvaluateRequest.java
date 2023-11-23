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
@Table(name = "re_evaluate_request")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReEvaluateRequest implements Serializable {

    private static final long serialVersionUID = -197553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "send_user_id")
    private Long sentUserId;

    @Column(name = "receive_user_id")
    private Long receiveUserId;

    @Column(name = "employee_performance_id")
    private Long employeePerformanceId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "request_time")
    private LocalDateTime requestTime;

    @Column(name = "handled_time")
    private LocalDateTime handledTime;

    @Column(name = "note")
    private String note;
}
