package com.example.todo.http.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse implements Response {
    private int errorStatus;
    private String message;
}
