package com.example.todo.controller.task;

import com.example.todo.controller.ControllerInterface;
import com.example.todo.service.JwtService;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TaskController implements ControllerInterface {

    @Autowired
    protected JwtService jwtService;

    @Autowired
    protected TaskService taskService;
}
