package com.example.backend.domain.user.service;

import com.example.backend.domain.user.controller.dto.request.UserRequestDto;
import com.example.backend.domain.user.controller.dto.response.UserResponseDto;
import com.example.backend.domain.user.model.OrderType;
import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.model.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.backend.domain.user.model.OrderType.ASC;

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
