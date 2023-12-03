package com.example.todo.controller;

import com.example.todo.dto.ProfileModificationDto;
import com.example.todo.model.ProfileModificationRequest;
import com.example.todo.model.User;
import com.example.todo.service.JwtService;
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

    @Autowired
    JwtService jwtService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/get-self")
    public ResponseEntity<?> getSelf(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().body(userService.getUserById(Long.parseLong(jwtService.extractId(token.substring(7)))));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestParam Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllMember());
    }

    @PutMapping("/modify-self")
    public ResponseEntity<?> modifySelf(@RequestBody ProfileModificationDto profileModificationDto) {
        return ResponseEntity.ok().body(userService.modifySelf(profileModificationDto));
    }

    @GetMapping("/all-account")
    public ResponseEntity<?> getAllAccounts(@RequestParam Integer page,
                                            @RequestParam Integer pageSize) {
        return ResponseEntity.ok().body(userService.getAccounts(page - 1, pageSize));
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<?> deleteAccount(@RequestParam Long userId) {
        userService.deleteAccount(userId);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/edit-account")
    public ResponseEntity<?> editAccount(@RequestBody User user) {
        userService.editAccount(user);
        return ResponseEntity.ok().body(null);
    }
}
