package com.example.retrofit.domain;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsServiceImpl implements PostsService {

    private final PostsReader postsReader;

    @Override
    public PostsInfo.Posts getPosts(Long userId) {
        return postsReader.getPosts(userId);
    }
}
