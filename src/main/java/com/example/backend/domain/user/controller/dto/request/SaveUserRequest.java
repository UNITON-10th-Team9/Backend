package com.example.backend.domain.user.controller.dto.request;

import com.example.backend.domain.user.model.Position;
import lombok.*;

@Getter
@Builder
public class SaveUserRequest {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final Position position;
    private final String organization;
    private final String annual;
    private final String profileImageUrl;
    private final String introduce;
    private final String profileUrl;
}
