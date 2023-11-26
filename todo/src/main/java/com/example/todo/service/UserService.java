package com.example.todo.service;

import com.example.todo.dto.BaseMemberDto;
import com.example.todo.exception.NoResultException;
import com.example.todo.exception.WrongPasswordException;
import com.example.todo.http.request.UserRequest;
import com.example.todo.model.User;
import com.example.todo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id);
        if(user == null) {
            throw new NoResultException("Found no user with id = " + id);
        }
        return user;
    }

    public List<BaseMemberDto> getAllMember() {
        return userRepository.findAllMember();
    }
}
