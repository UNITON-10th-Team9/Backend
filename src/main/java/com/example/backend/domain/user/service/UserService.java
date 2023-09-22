package com.example.backend.domain.user.service;

import com.example.backend.domain.user.controller.dto.response.UserInformationDto;
import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.model.repository.UserRepository;
import com.example.backend.global.error.exception.CustomeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.backend.global.error.exception.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserInformationDto getUserInformation(final String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new CustomeException(USER_NOT_FOUND));

        return UserInformationDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .position(user.getPosition())
                .organization(user.getOrganization())
                .build();
    }
}
