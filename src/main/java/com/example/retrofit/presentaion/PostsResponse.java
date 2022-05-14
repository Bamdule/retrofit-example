package com.example.retrofit.presentaion;

import com.example.retrofit.domain.PostsInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class PostsResponse {

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class Posts {
        private Long id;

        private Long userId;

        private String title;

        private String body;

        public static Posts of(PostsInfo.Posts posts) {
            return Posts
                .builder()
                .id(posts.getId())
                .userId(posts.getUserId())
                .title(posts.getTitle())
                .body(posts.getBody())
                .build();
        }
    }
}
