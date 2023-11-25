package com.example.todo.model;

import com.example.todo.enums.RequestType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "work_request")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkRequest implements Serializable {

    private static final long serialVersionUID = -197553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "send_user_id")
    private Long sentUserId;

    @Column(name = "receive_user_id")
    private Long receiveUserId;

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

    @Column(name = "is_approved_by_head_of_dep")
    private Boolean isApprovedByHeadOfDep = false;

    @Transient
    private RequestType type = RequestType.CONG_VIEC;
}
