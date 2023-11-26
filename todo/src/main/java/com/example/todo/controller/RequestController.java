package com.example.todo.controller;

import com.example.todo.enums.RequestType;
import com.example.todo.service.JwtService;
import com.example.todo.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
@AllArgsConstructor
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/all-sent")
    public ResponseEntity<?> getAllSentRequest(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().body(requestService.getAllSentRequest(Long.parseLong(jwtService.extractId(token.substring(7)))));
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getRequestDetail(@RequestParam(name = "id") Long id,
                                              @RequestParam(name = "type") RequestType requestType) {
        return ResponseEntity.ok().body(requestService.getRequestDetail(id, requestType));
    }

    @PostMapping("/send-new-request")
    public ResponseEntity<?> getRequestDetail(@RequestBody Object request,
                                              RequestType requestType,
                                              @RequestHeader("Authorization") String token) {
        requestService.addNewRequest(request, requestType, Long.parseLong(jwtService.extractId(token.substring(7))));
        return ResponseEntity.ok().body(null);
    }
}
