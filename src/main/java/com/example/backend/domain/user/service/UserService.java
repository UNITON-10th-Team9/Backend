package com.example.backend.domain.user.service;

import com.example.backend.domain.user.controller.dto.request.UserRequestDto;
import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.model.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
