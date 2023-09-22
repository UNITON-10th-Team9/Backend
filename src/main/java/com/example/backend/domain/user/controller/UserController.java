package com.example.backend.domain.user.controller;

import com.example.backend.domain.user.controller.dto.response.UserInformationDto;
import com.example.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public UserInformationDto getUserInformation(@RequestParam String phoneNumber) {
        return userService.getUserInformation(phoneNumber);
    }
}
