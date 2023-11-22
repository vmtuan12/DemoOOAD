package com.example.todo.controller.user;

import com.example.todo.controller.ControllerInterface;
import com.example.todo.http.request.UserRequest;
import com.example.todo.model.User;
import com.example.todo.model.UserRole;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/admin")
public class AdminController extends UserController {

    @GetMapping("/users")
    public List<User> allUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/userid={userId}")
    public User getUser(@PathVariable(name = "userId") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) {
        userService.addUser(new User(userRequest.getUsername(), userRequest.getPassword(), String.valueOf(UserRole.ROLE_USER)));
        return ResponseEntity.ok("create account successfully");
    }

    @DeleteMapping("/remove-user/{userId}")
    public ResponseEntity<?> removeUser(@PathVariable(name = "userId") Integer id) {
        userService.removeUser(id);
        return ResponseEntity.ok("remove account successfully");
    }

    @PutMapping("/modify-user/{userId}")
    public ResponseEntity<?> modifyUser(@PathVariable(name = "userId") Integer id,
                                        @RequestBody UserRequest userRequest) {
        userService.modifyUser(id, userRequest);
        return ResponseEntity.ok("modify account successfully");
    }
}
