package com.example.todo.controller.auth;

import com.example.todo.controller.ControllerInterface;
import com.example.todo.http.response.AuthResponse;
import com.example.todo.http.request.AuthRequest;
import com.example.todo.http.response.ErrorResponse;
import com.example.todo.http.response.Response;
import com.example.todo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController implements ControllerInterface {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @PostMapping("/sign-in")
    public Response authenticate(@RequestBody AuthRequest request) {
        System.out.println(request);
        if(request.getUsername() == null || request.getPassword() == null) {
            throw new RuntimeException("missing parameter");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), null));
        if(authentication.isAuthenticated()) {
            return new AuthResponse(jwtService.generateToken(request.getUsername()));
        } else {
            return new ErrorResponse(400,"user not found");
        }
    }
}
