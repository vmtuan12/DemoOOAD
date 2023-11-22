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

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUserById(Integer id) {
        User user = userRepository.getUserById(id);
        if(user == null) {
            throw new NoResultException("Found no user with id = " + id);
        }
        return user;
    }

    public void removeUser(Integer id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public void modifyUser(Integer id, UserRequest userRequest) {
        User user = getUserById(id);
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);
    }

    public void changePassword(Integer id, String currentPassword, String newPassword) {
        User user = getUserById(id);
        String passwordFromDB = userRepository.getPasswordById(id);
        boolean passwordMatched = passwordEncoder.matches(currentPassword, passwordFromDB);
        if(passwordMatched) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        } else {
            throw new WrongPasswordException("Wrong current password");
        }
    }
}
