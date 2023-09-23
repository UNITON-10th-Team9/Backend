package com.example.backend.domain.user.controller.dto.response;

import com.example.backend.domain.user.model.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListReponse {

    private final List<UserElement> userList;

    @Builder
    @Getter
    public static class UserElement {
        private final Long id;
        private final String name;
        private final String email;
        private final String phoneNumber;
        private final Position position;
        private final String organization;
        private final Integer annual;
        private final String profileImageUrl;
        private final String introduce;
        private final String[] profileUrl;
    }
}
