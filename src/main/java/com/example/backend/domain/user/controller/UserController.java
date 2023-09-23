package com.example.backend.domain.user.controller;

import com.example.backend.domain.user.controller.dto.request.SaveUserRequest;
import com.example.backend.domain.user.controller.dto.response.UserInformationDto;
import com.example.backend.domain.user.controller.dto.response.UserListReponse;
import com.example.backend.domain.user.model.OrderType;
import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public UserListReponse getUsers(@RequestParam("position") Position position, @RequestParam("orderType") OrderType orderType) {
        return userService.getUsers(position, orderType);
    }
}
