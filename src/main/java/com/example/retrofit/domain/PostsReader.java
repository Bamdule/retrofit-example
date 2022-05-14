package com.example.retrofit.domain;

public interface PostsReader {

    PostsInfo.Posts getPosts(Long userId);
}
