package com.example.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountTableDto {
    private Integer pageCount;
    private List<AccountDto> accounts;
}
