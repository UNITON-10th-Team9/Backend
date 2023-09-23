package com.example.backend.domain.user.service;

import com.example.backend.domain.user.controller.dto.request.UserRequestDto;
import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.model.repository.UserRepository;
import com.example.backend.global.error.exception.CustomeException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void saveUser(SaveUserRequest request) {
        Optional<User> user = userRepository.findByPhoneNumber(request.getPhoneNumber());

        User userEntity = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .organization(request.getOrganization())
                .position(request.getPosition())
                .annual(request.getAnnual())
                .profileImageUrl(request.getProfileImageUrl())
                .introduce(request.getIntroduce())
                .build();

        if (user.isPresent()) {
            userRepository.updateUserById(user.get().getId(), userEntity);
        } else {
            userRepository.save(userEntity);
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

    public List<UserResponseDto> getUsers(final Position position, final OrderType orderType) {
        if (orderType == ASC) return userRepository.findByPositionOrderByAnnual(position)
                .stream()
                .map(UserResponseDto::of)
                .collect(Collectors.toList());

        return userRepository.findByPositionOrderByAnnualDesc(position)
                .stream()
                .map(UserResponseDto::of)
                .collect(Collectors.toList());
    }

    public List<UserResponseDto> getUsers(final OrderType orderType) {
        if (orderType == ASC) return userRepository.findAllByOrderByAnnualAsc()
                .stream()
                .map(UserResponseDto::of)
                .collect(Collectors.toList());

        return userRepository.findAllByOrderByAnnualDesc()
                .stream()
                .map(UserResponseDto::of)
                .collect(Collectors.toList());
    }
}
