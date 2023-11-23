package com.example.todo.service;

import com.example.todo.exception.NoResultException;
import com.example.todo.exception.WrongPasswordException;
import com.example.todo.http.request.UserRequest;
import com.example.todo.model.User;
import com.example.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ServiceInterface {

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
}
