package com.example.todo.controller;

import com.example.todo.model.User;
import com.example.todo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestParam Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllMember());
    }
}
