package com.example.retrofit.application;

import org.springframework.stereotype.Component;

import com.example.retrofit.domain.PostsInfo;
import com.example.retrofit.domain.PostsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PostsFacade {

    private final PostsService postsService;

    public PostsInfo.Posts getPosts(Long userId) {
        return postsService.getPosts(userId);
    }
}
