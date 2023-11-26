package com.example.todo.controller;

import com.example.todo.service.JwtService;
import com.example.todo.service.MonthlySalaryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
@AllArgsConstructor
public class MonthlySalaryController {

    @Autowired
    MonthlySalaryService monthlySalaryService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/own")
    public ResponseEntity<?> getOwnSalary(@RequestHeader("Authorization") String token,
                                          @RequestParam(required = false) Integer year,
                                          @RequestParam(required = false) Integer quarter,
                                          @RequestParam(required = false) Integer month) {
        return ResponseEntity.ok().body(monthlySalaryService.getSalaryUser(Long.parseLong(jwtService.extractId(token.substring(7))), year, quarter, month));
    }

}
