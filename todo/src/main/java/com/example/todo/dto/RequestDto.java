package com.example.todo.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface RequestDto {
    Long getId();
    String getType();
    String getReceiveUser();
    String getTitle();
    String getContent();
    String getNote();
    LocalDateTime getRequestTime();
    LocalDateTime getHandledTime();
    Object getStatus();

    default String getRequestTimeStr() {
        if (getRequestTime() == null) {
            return null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return getRequestTime().format(formatter);
        }
    }

    default String getHandledTimeStr() {
        if (getHandledTime() == null) {
            return "N/a";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return getHandledTime().format(formatter);
        }
    }

    default String getStatusStr() {

        if (getStatus() == null) {
            return "Chờ xử lý";
        } else if ((getStatus() instanceof Integer && getStatus().equals(1)) || (getStatus() instanceof Boolean && getStatus().equals(true))) {
            return "Phê duyệt";
        } else {
            return "Từ chối";
        }
    }
}
