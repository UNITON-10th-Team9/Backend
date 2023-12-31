package com.example.backend.domain.user.controller;

import com.example.backend.domain.user.controller.dto.request.SaveUserRequest;
import com.example.backend.domain.user.controller.dto.response.UserInformationDto;
import com.example.backend.domain.user.controller.dto.response.UserListReponse;
import com.example.backend.domain.user.model.OrderType;
import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.service.UserCsvService;
import com.example.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;
    private final UserCsvService userCsvService;

    @PostMapping()
    public void saveUser(@RequestBody SaveUserRequest body) {
        userService.saveUser(body);
    }

    @PostMapping("/csv")
    public void saveUser(@RequestPart("file") MultipartFile file) {
        userCsvService.save(file);
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
