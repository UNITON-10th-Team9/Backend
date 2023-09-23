package com.example.backend.domain.event.service;

import com.example.backend.domain.event.model.Event;
import com.example.backend.domain.event.model.EventRepository;
import com.example.backend.domain.event.controller.dto.EventResDto;
import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.model.repository.UserRepository;
import com.example.backend.global.error.exception.CustomeException;
import com.example.backend.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventResDto getRandomEvent() {
        Random rand = new Random();
        Long randomNum = (long)rand.nextInt(10) + 1;

        Event event = eventRepository.findById(randomNum)
                .orElseThrow(() -> new CustomeException(ErrorCode.INTERNAL_SERVER_ERROR));

        List<User> randomUsers = userRepository.findRandomUsers();

        return new EventResDto(event, randomUsers);
    }

}
