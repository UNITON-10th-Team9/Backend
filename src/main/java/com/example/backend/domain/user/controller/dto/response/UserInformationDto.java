package com.example.backend.domain.user.controller.dto.response;

import com.example.backend.domain.user.model.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserInformationDto {
    private String name;
    private String email;
    private Position position;
    private String organization;
    private String annual;
    private String[] profileUrl;
}
