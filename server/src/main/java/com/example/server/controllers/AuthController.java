package com.example.server.controllers;

import com.example.server.dtos.AppointmentDTO;
import com.example.server.dtos.LoginDTO;
import com.example.server.dtos.RegisterDTO;
import com.example.server.entities.AppointmentEntity;
import com.example.server.entities.UserEntity;
import com.example.server.services.AppointmentService;
import com.example.server.services.AuthService;
import com.example.server.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity create(@RequestBody RegisterDTO registerDTO){
        return authService.register(registerDTO);
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody LoginDTO loginDTO){
        return authService.login(loginDTO);
    }

    @PostMapping("/check")
    public Long check(){
        return authService.checkAuth();
    }
}
