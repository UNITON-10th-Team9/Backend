package com.example.backend.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomeException extends RuntimeException {

    private final ErrorCode errorCode;

}
