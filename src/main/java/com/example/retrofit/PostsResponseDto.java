package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class PostsResponseDto {

    @ToString
    @Getter
    public static class Posts {

        @Builder
        public Posts(Long userId, Long id, String title, String body) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.body = body;
        }

        @SerializedName("userId")
        private Long userId;

        @SerializedName("id")
        private Long id;

        @SerializedName("title")
        private String title;

        @SerializedName("body")
        private String body;
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

        @SerializedName("userId")
        private Long userId;

        @SerializedName("id")
        private Long id;

        @SerializedName("title")
        private String title;

        private String body;
    }
}
