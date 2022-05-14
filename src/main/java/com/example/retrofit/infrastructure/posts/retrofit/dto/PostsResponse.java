package com.example.retrofit.infrastructure.posts.retrofit.dto;

import com.example.retrofit.domain.PostsInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class PostsResponse {

    @ToString
    @Getter
    public static class Posts {
        @JsonProperty("userId")
        private Long userId;

        @JsonProperty("id")
        private Long id;

        @JsonProperty("title")
        private String title;

        @JsonProperty("body")
        private String body;

        @Builder
        public Posts(Long userId, Long id, String title, String body) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.body = body;
        }

        public PostsInfo.Posts to() {
            return PostsInfo.Posts
                .builder()
                .id(this.id)
                .userId(this.userId)
                .body(this.body)
                .title(this.title)
                .build();
        }
    }

    @ToString
    @Getter
    public static class Create {

        @Builder
        public Create(Long userId, Long id, String title, String body) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.body = body;
        }

        @JsonProperty("userId")
        private Long userId;

        @JsonProperty("id")
        private Long id;

        @JsonProperty("title")
        private String title;

        private String body;
    }
}
