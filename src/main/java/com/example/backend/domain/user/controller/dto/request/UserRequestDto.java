package com.example.backend.domain.user.controller.dto.request;

import com.example.backend.domain.user.model.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class UserRequestDto {
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
}
