package com.example.todo.service;

import com.example.todo.dto.SalaryDto;
import com.example.todo.repository.MonthlySalaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@AllArgsConstructor
public class MonthlySalaryService {

    @Autowired
    MonthlySalaryRepository monthlySalaryRepository;

    public List<SalaryDto> getSalaryUser(Long userId, Integer year, Integer quarter, Integer month) {
        if (year == null) {
            year = 2023;
        }

        Integer startMonth = 1;
        Integer endMonth = 12;

        if (quarter != null) {
            endMonth = quarter*3;
            startMonth = endMonth - 2;
        }
        if (month != null) {
            startMonth = month;
            endMonth = month;
        }

        return monthlySalaryRepository.getSalaryUser(userId, startMonth, endMonth, year);
    }
}
