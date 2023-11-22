package com.example.todo.http.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangePasswordRequest implements Request{
    private String currentPassword;
    private String newPassword;
}
