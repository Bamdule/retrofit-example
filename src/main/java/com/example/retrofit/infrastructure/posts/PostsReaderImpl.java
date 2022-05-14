package com.example.retrofit.infrastructure.posts;

import org.springframework.stereotype.Component;

import com.example.retrofit.domain.PostsInfo;
import com.example.retrofit.domain.PostsReader;
import com.example.retrofit.infrastructure.posts.retrofit.dto.PostsResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PostsReaderImpl implements PostsReader {

    private final PostsCaller postsCaller;

    @Override
    public PostsInfo.Posts getPosts(Long userId) {
        PostsResponse.Posts posts = postsCaller.getPosts(userId);

        return posts.to();
    }
}
