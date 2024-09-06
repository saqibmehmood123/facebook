package com.example.facebookclone.controller;

import com.example.facebookclone.dto.RegisterDto;
import com.example.facebookclone.dto.TokenDto;
import com.example.facebookclone.dto.UserDTO;
import com.example.facebookclone.request.LoginRequest;
import com.example.facebookclone.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.facebookclone.service.AuthService;
@RestController
@RequestMapping("/authcontroller")
///@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private  AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));

    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDto) {
        System.out.println("  this is   register  method in auth controller ");
        return ResponseEntity.ok(authService.register(userDto));
    }
}