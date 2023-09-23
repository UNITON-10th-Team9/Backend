package com.example.backend.domain.user.model.repository.vo;

import com.example.backend.domain.user.model.Position;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class UserListVo {
    private final Long id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final Position position;
    private final String organization;
    private final Integer annual;
    private final String profileImageUrl;
    private final String introduce;
    private final String profileUrl;

    @QueryProjection
    public UserListVo(Long id, String name, String email, String phoneNumber, Position position, String organization, Integer annual, String profileImageUrl, String introduce, String profileUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.organization = organization;
        this.annual = annual;
        this.profileImageUrl = profileImageUrl;
        this.introduce = introduce;
        this.profileUrl = profileUrl;
    }
}
