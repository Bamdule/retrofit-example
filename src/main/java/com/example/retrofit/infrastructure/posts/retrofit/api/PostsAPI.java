package com.example.retrofit.infrastructure.posts.retrofit.api;

import java.util.List;

import com.example.retrofit.infrastructure.posts.retrofit.dto.PostsRequest;
import com.example.retrofit.infrastructure.posts.retrofit.dto.PostsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostsAPI {

    //@Path : Path 변수를 사용한다
    @GET("/posts/{userId}")
    Call<PostsResponse.Posts> getPosts(@Path("userId") Long userId);

    //@Query : QueryString을 사용한다. (?userId=1)
    @GET("/posts")
    Call<List<PostsResponse.Posts>> getAllPosts(@Query("userId") Long userId);


    //@Body 어노테이션 파라미터에 정의하면 파라미터 객체를 JSON으로 파싱하며, ContentType이 application/json으로 정의된다
    @POST("/posts")
    Call<PostsResponse.Create> createPosts(@Body PostsRequest.Create create);

    //@FormUrlEncoded 어노테이션을 정의하면, ContentType이 application/x-www-form-urlencoded으로 정의된다
    @FormUrlEncoded
    @POST("/posts")
    Call<PostsResponse.Create> createPostsByFormUrlEncoded(
        @Field("userId") Long userId,
        @Field("title") String title,
        @Field("body") String body
    );
}
