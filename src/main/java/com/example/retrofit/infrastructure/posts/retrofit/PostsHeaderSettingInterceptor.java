package com.example.retrofit.infrastructure.posts.retrofit;

import java.io.IOException;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@RequiredArgsConstructor
@Component
public class PostsHeaderSettingInterceptor implements Interceptor {

    private final String TOKEN_HEADER_VALUE = "TEST_TOKEN";
    private final String TOKEN_HEADER_KEY = "authorization";

    @Override
    public Response intercept(final Chain chain) throws IOException {
        return chain.proceed(signedRequest(chain));
    }

    private Request signedRequest(final Chain chain) {
        return chain.request().newBuilder()
            .header(TOKEN_HEADER_KEY, TOKEN_HEADER_VALUE)
            .build();
    }

}
