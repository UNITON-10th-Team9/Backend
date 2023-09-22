package com.example.backend.domain.user.controller;

import com.example.backend.domain.user.controller.dto.request.UserRequestDto;
import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public void saveUser(@RequestBody UserRequestDto body) {
        userService.saveUser(body);
    }
}
