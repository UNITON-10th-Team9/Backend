package com.example.backend.domain.user.service;

import com.example.backend.domain.user.controller.dto.request.SaveUserRequest;
import com.example.backend.domain.user.controller.dto.response.UserInformationDto;
import com.example.backend.domain.user.controller.dto.response.UserListReponse;
import com.example.backend.domain.user.model.OrderType;
import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.model.repository.UserRepository;
import com.example.backend.domain.user.model.repository.vo.UserListVo;
import com.example.backend.global.error.exception.CustomeException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.backend.domain.user.controller.dto.response.UserListReponse.UserElement;
import static com.example.backend.global.error.exception.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void saveUser(SaveUserRequest request) {
        Optional<User> user = userRepository.findByPhoneNumber(request.getPhoneNumber());
        String profileUrl;
        if (request.getProfileUrl() != null) {
            profileUrl = String.join(", ", request.getProfileUrl());
        } else {
            profileUrl = "";
        }

        User userEntity = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .organization(request.getOrganization())
                .position(request.getPosition())
                .annual(request.getAnnual())
                .introduce(request.getIntroduce())
                .profileUrl(profileUrl)
                .build();

        if (user.isPresent()) {
            userRepository.save(userEntity.updateId(user.get().getId()));
        } else {
            userRepository.save(userEntity);
        }
    }

    public UserInformationDto getUserInformation(final String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new CustomeException(USER_NOT_FOUND));

        String[] profileUrl = Arrays.stream(user.getProfileUrl().split(",")).map(String::trim).toArray(String[]::new);

        return UserInformationDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .position(user.getPosition())
                .organization(user.getOrganization())
                .annual(user.getAnnual())
                .profileUrl(profileUrl)
                .build();
    }

    public UserListReponse getUsers(Position position, OrderType orderType) {
        List<UserElement> userList = userRepository.findAllByPositionAndOrderType(position, orderType)
                .stream()
                .map(this::userListResponseBuilder)
                .toList();

        return new UserListReponse(userList);
    }

    private UserElement userListResponseBuilder(UserListVo vo) {
        String[] profileUrl = Arrays.stream(vo.getProfileUrl().split(",")).map(String::trim).toArray(String[]::new);

        return UserElement.builder()
                .id(vo.getId())
                .name(vo.getName())
                .email(vo.getEmail())
                .phoneNumber(vo.getPhoneNumber())
                .position(vo.getPosition())
                .organization(vo.getOrganization())
                .annual(vo.getAnnual())
                .profileImageUrl(vo.getProfileImageUrl())
                .introduce(vo.getIntroduce())
                .profileUrl(profileUrl)
                .build();
    }
}
