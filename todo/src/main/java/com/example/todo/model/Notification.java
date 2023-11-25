package com.example.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "notification")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {

    private static final long serialVersionUID = -197553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "sent_time")
    private LocalDateTime sentTime;

    @Transient
    public String getSentTimeStr() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return sentTime.format(formatter);
    }
}
