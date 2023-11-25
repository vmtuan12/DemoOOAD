package com.example.todo.service;

import com.example.todo.model.Notification;
import com.example.todo.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications(Long userId) {
        return notificationRepository.findAllByUserId(userId);
    }

    public void checkNotification(Long notiId) {
        Notification notification = notificationRepository.findById(notiId).orElse(null);
        if (notification == null) {
            throw new RuntimeException("lỗi");
        } else {
            notification.setStatus(true);
            notificationRepository.save(notification);
        }
    }
}
