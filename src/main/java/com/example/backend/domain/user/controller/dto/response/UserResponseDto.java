package com.example.backend.domain.user.controller.dto.response;

import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Position position;
    private String organization;
    private int annual;
    private String profileImageUrl;
    private String introduce;
    private String githubUrl;
    private String linkedInUrl;
    private String instagramUrl;

    public static UserResponseDto of(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .position(user.getPosition())
                .organization(user.getOrganization())
                .annual(user.getAnnual())
                .profileImageUrl(user.getProfileImageUrl())
                .introduce(user.getIntroduce())
                .githubUrl(user.getGithubUrl())
                .linkedInUrl(user.getLinkedInUrl())
                .instagramUrl(user.getInstagramUrl())
                .build();
    }
}
