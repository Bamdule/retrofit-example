package com.example.retrofit;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitRegistry {

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    private static final HttpLoggingInterceptor loggingInterceptor
        = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private final Gson gson = new GsonBuilder()
        .setLenient()
        .create();
    @Bean
    PostsAPI getJsonPlaceHolderAPI() {
        OkHttpClient client = new OkHttpClient.Builder()
            //서버로 요청하는데 걸리는 시간을 제한 (15초 이내에 서버에 요청이 성공해야한다. (handshake))
            .connectTimeout(15, TimeUnit.SECONDS)
            //서버로 요청이 성공했고, 응답데이터를 받는데 시간을 제한한다. (15초 이내에 응답 데이터를 전달받아야한다)
            .readTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build();

        return new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(PostsAPI.class);
    }

}
