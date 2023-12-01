package com.example.todo.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthResponse implements Response{
    private String token;
    private String role;
}
