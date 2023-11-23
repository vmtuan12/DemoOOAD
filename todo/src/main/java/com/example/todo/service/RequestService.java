package com.example.todo.service;

import com.example.todo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequestService {

    @Autowired
    PersonalRequestRepository personalRequestRepository;

    @Autowired
    WorkRequestRepository workRequestRepository;

    @Autowired
    FixedSalaryChangeRequestRepository fixedSalaryChangeRequestRepository;

    @Autowired
    MonthlySalaryComplainRequestRepository monthlySalaryComplainRequestRepository;

    @Autowired
    ProfileModificationRequestRepository profileModificationRequestRepository;

    @Autowired
    ReEvaluateRequestRepository reEvaluateRequestRepository;
}
