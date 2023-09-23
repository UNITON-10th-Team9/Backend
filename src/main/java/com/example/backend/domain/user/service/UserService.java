package com.example.backend.domain.user.service;

import com.example.backend.domain.user.controller.dto.request.UserRequestDto;
import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.model.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

    @Transactional
    public void saveUser(final UserRequestDto body) {
        Optional<User> findUser = userRepository.findByPhoneNumber(body.getPhoneNumber());

        if (findUser.isPresent()) {
            User user = findUser.get();
            user.setUserInformation(body);
        } else {
            User user = User.builder()
                    .name(body.getName())
                    .email(body.getEmail())
                    .phoneNumber(body.getPhoneNumber())
                    .position(body.getPosition())
                    .organization(body.getOrganization())
                    .annual(body.getAnnual())
                    .profileImageUrl(body.getProfileImageUrl())
                    .introduce(body.getIntroduce())
                    .build();
            userRepository.save(user);
        }
    }
  
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
