package com.example.backend.domain.user.controller;

import com.example.backend.domain.user.controller.dto.request.UserRequestDto;
import com.example.backend.domain.user.controller.dto.response.UserResponseDto;
import com.example.backend.domain.user.model.OrderType;
import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public void saveUser(@RequestBody UserRequestDto body) {
        userService.saveUser(body);
    }

    @GetMapping
    public List<UserResponseDto> getUsers(final @RequestParam String position, final @RequestParam String orderType) {
        OrderType type;
        if (orderType.isBlank()) type = null;
        else type = OrderType.valueOf(orderType);

        if (position.isBlank()) return userService.getUsers(type);

        Position pos = Position.valueOf(position);
        return userService.getUsers(pos, type);
    }
}
