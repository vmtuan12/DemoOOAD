package com.example.todo.controller.user;

import com.example.todo.controller.ControllerInterface;
import com.example.todo.service.JwtService;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserController implements ControllerInterface {

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;
}
