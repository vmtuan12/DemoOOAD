package com.example.todo.controller;

import com.example.todo.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {

    @Autowired
    NotificationService notificationService;
}
