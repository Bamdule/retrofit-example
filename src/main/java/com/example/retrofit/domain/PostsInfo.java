package com.example.retrofit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class PostsInfo {

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class Posts {

        private Long id;

        private Long userId;

        private String title;

        private String body;
    }
}
