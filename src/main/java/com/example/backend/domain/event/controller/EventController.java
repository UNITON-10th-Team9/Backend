package com.example.backend.domain.event.controller;

import com.example.backend.domain.event.controller.dto.EventResDto;
import com.example.backend.domain.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public EventResDto getEvents() {
        return eventService.getRandomEvent();
    }
}
