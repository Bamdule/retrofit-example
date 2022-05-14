package com.example.retrofit.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    RETROFIT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "RETROFIT ERROR")
    ;


    private final HttpStatus httpStatus;
    private final String message;
}
