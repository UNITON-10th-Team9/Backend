package com.example.backend.domain.event.controller.dto;

import com.example.backend.domain.event.model.Event;
import com.example.backend.domain.user.model.User;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EventResDto {
    private final EventDto event;
    final List<UserSimpleRes> users;

    public EventResDto(Event event, List<User> users) {
        this.event = new EventDto(event);
        this.users = users
                .stream()
                .map(UserSimpleRes::new)
                .collect(Collectors.toList());
    }
}

@Getter
class EventDto {
    String content;

    public EventDto(Event event) {
        this.content = event.getContent();
    }
}

@Getter
class UserSimpleRes {
    String name;
    String organization;
    int annual;

    public UserSimpleRes(User user) {
        this.name = user.getName();
        this.organization = user.getOrganization();
        this.annual = user.getAnnual();
    }
}
