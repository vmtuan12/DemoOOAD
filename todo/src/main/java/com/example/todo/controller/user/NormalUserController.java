package com.example.todo.controller.user;

import com.example.todo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/normal-user")
public class NormalUserController extends UserController {

    @GetMapping("/test")
    public List<User> allUser() {
        return userService.findAllUsers();
    }
}
