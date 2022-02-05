package com.example.retrofit;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RetrofitTest {

    @Autowired
    private PostsCallerImpl postsCaller;

    @Test
    @DisplayName("단일 포스트를 조회한다")
    public void 단일_포스트를_조회한다() {
        PostsResponseDto.Posts posts = postsCaller.getPosts(50L);
    }

    @Test
    @DisplayName("포스트 리스트를 조회한다")
    public void 포스트_리스트를_조회한다() {
        List<PostsResponseDto.Posts> posts = postsCaller.getAllPosts(1L);
    }

    @Test
    @DisplayName("포스트를 생성한다 (application/json)")
    public void 포스트를_생성한다() {
        PostsRequestDto.Create request = PostsRequestDto.Create.builder()
            .userId(30L)
            .title("안녕하세요?")
            .body("반갑습니다.")
            .build();

        PostsResponseDto.Create createResponse = postsCaller.createPosts(request);

    }
    @Test
    @DisplayName("포스트를 생성한다 (application/x-www-form-urlencoded)")
    public void 포스트를_생성한다2() {
        PostsRequestDto.Create request = PostsRequestDto.Create.builder()
            .userId(30L)
            .title("안녕하세요?")
            .body("반갑습니다.")
            .build();

        PostsResponseDto.Create createResponse = postsCaller.createPostsByForm(request);

    }
}
