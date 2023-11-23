package com.example.todo.service;

import com.example.todo.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;
}
