package com.example.todo.http.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest implements Request {
    private String title;
    private String description;
    private Integer status;
}
