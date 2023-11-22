package com.example.todo.controller.user;

import com.example.todo.http.request.ChangePasswordRequest;
import com.example.todo.http.response.PersonalInfoResponse;
import com.example.todo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/general")
public class GeneralUserController extends UserController {

    @GetMapping("/own-info")
    public PersonalInfoResponse getInfo(@RequestHeader("Authorization") String token) {
        Integer userId = Integer.parseInt(jwtService.extractId(token.substring(7)));
        User user = userService.getUserById(userId);
        return new PersonalInfoResponse(user.getUsername(), user.getRole());
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request,
                                            @RequestHeader("Authorization") String token) {
        Integer userId = Integer.parseInt(jwtService.extractId(token.substring(7)));
        userService.changePassword(userId, request.getCurrentPassword(), request.getNewPassword());
        return ResponseEntity.ok("Change password successfully");
    }
}
