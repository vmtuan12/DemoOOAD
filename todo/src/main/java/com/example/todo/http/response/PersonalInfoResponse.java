package com.example.todo.http.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonalInfoResponse implements Response {
    private String username;
    private String role;
}
