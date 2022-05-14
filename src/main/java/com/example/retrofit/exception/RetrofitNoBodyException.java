package com.example.retrofit.exception;

import org.springframework.http.HttpStatus;

public class RetrofitNoBodyException extends RetrofitException {

    public RetrofitNoBodyException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Retrofit 요청 시 ResponseBody가 존재하지 않아 에러가 발생했습니다.");
    }
}
