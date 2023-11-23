package com.example.todo.controller;

import com.example.todo.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
@AllArgsConstructor
public class RequestController {

    @Autowired
    RequestService requestService;
}
