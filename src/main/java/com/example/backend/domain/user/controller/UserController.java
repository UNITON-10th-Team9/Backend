package com.example.backend.domain.user.controller;

import com.example.backend.domain.user.controller.dto.request.SaveUserRequest;
import com.example.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.backend.domain.user.controller.dto.response.UserInformationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public void saveUser(@RequestBody SaveUserRequest body) {
        userService.saveUser(body);
    }
      
    @GetMapping("/info")
    public UserInformationDto getUserInformation(@RequestParam String phoneNumber) {
        return userService.getUserInformation(phoneNumber);
    }
}
