package com.example.retrofit.infrastructure.posts.retrofit;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.retrofit.infrastructure.posts.retrofit.api.PostsAPI;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@RequiredArgsConstructor
@Configuration
public class PostsRetrofitConfiguration {

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    private final ObjectMapper objectMapper;

    private final PostsHeaderSettingInterceptor postsHeaderSettingInterceptor;

    @Bean
    public OkHttpClient getClient() {

        final HttpLoggingInterceptor loggingInterceptor
            = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
            .hostnameVerifier((hostname, session) -> true)
            .addInterceptor(postsHeaderSettingInterceptor)
            .addInterceptor(loggingInterceptor)
            //서버로 요청하는데 걸리는 시간을 제한 (15초 이내에 서버에 요청이 성공해야한다. (handshake))
            .connectTimeout(15, TimeUnit.SECONDS)
            //서버로 요청이 성공했고, 응답데이터를 받는데 시간을 제한한다. (15초 이내에 응답 데이터를 전달받아야한다)
            .readTimeout(15, TimeUnit.SECONDS)
            .build();

    }

    @Bean
    public PostsAPI getPostsAPI(OkHttpClient client) {
        return new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .client(client)
            .build()
            .create(PostsAPI.class);
    }

}
