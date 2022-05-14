package com.example.retrofit.infrastructure.posts.retrofit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

public class PostsRequest {

    @Getter
    public static class Create {

        @Builder
        public Create(Long userId, String title, String body) {
            this.userId = userId;
            this.title = title;
            this.body = body;
        }

        @JsonProperty("userId")
        private Long userId;

        private String title;

        private String body;
    }
}
