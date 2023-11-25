package com.example.todo.controller;

import com.example.todo.service.JwtService;
import com.example.todo.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllNotifications(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().body(notificationService.getAllNotifications(Long.parseLong(jwtService.extractId(token.substring(7)))));
    }

    @PutMapping("/check")
    public ResponseEntity<?> checkNotification(@RequestParam Long id) {
        notificationService.checkNotification(id);
        return ResponseEntity.ok().body(null);
    }
}
