package com.example.todo.service;

import com.example.todo.dto.RequestDto;
import com.example.todo.enums.RequestType;
import com.example.todo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<RequestDto> getAllSentRequest(Long userId) {
        return personalRequestRepository.getAllRequestsBySentUserId(userId);
    }

    public RequestDto getRequestDetail(Long id, RequestType type) {
        if (type == RequestType.CA_NHAN) {
            return personalRequestRepository.getDtoById(id);
        } else if (type == RequestType.CONG_VIEC) {
            return workRequestRepository.getDtoById(id);
        } else if (type == RequestType.CSHS) {
            return profileModificationRequestRepository.getDtoById(id);
        } else if (type == RequestType.RE_EVAL) {
            return reEvaluateRequestRepository.getDtoById(id);
        } else if (type == RequestType.FIXED_SAL) {
            return fixedSalaryChangeRequestRepository.getDtoById(id);
        } else {
            return monthlySalaryComplainRequestRepository.getDtoById(id);
        }
    }
}
