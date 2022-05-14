package com.example.retrofit.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class RetrofitException extends RuntimeException {

    private HttpStatus httpStatus;

    public RetrofitException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
