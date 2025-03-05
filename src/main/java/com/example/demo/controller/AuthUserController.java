package com.example.demo.controller;

import com.example.demo.dto.AuthUserDTO;
import com.example.demo.Service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    private final AuthenticationService authenticationService;
    public AuthUserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthUserDTO authUserDTO) {
        String response = authenticationService.register(authUserDTO);
        return ResponseEntity.status(201).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthUserDTO authUserDTO) {
        String response = authenticationService.login(authUserDTO);
        return ResponseEntity.ok(response);
    }
}
