package com.example.retrofit.infrastructure.common.retrofit;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.retrofit.exception.RetrofitException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import retrofit2.Call;
import retrofit2.Response;

@Log4j2
@RequiredArgsConstructor
@Component
public class CommonApiExecutor implements RetrofitApiExecutor {

    @Override
    public <T> Optional<T> execute(final Call<T> call) {
        try {
            Response<T> response = call.execute();

            if (response.isSuccessful()) {
                log.info("[Http API Call] {}", response.raw().toString());
                return Optional.ofNullable(response.body());
            }

            throw errorHandler(response);

        } catch (IOException e) {
            log.error("[Http API Call] {}", e.toString());
            throw new RetrofitException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    protected RetrofitException errorHandler(Response<?> response) throws IOException {
        if (Objects.isNull(response.errorBody())) {
            throw new RetrofitException(HttpStatus.INTERNAL_SERVER_ERROR, "API 요청 시 에러가 발생했습니다. (errorBody is null)");
        }

        log.error("[Http API Call] {}", response.raw().toString());
        throw new RetrofitException(HttpStatus.valueOf(response.code()), response.errorBody().string());
    }
}
