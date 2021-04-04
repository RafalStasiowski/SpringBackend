package com.example.backend.controller;

import com.example.backend.dto.RegisterRequest;
import com.example.backend.model.User;
import com.example.backend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
        return new ResponseEntity<>("User successfully registered", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity show() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(userService.show()));
    }
}
