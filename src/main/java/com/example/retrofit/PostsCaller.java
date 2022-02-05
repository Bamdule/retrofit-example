package com.example.retrofit;

import java.util.List;

public interface PostsCaller {

    PostsResponseDto.Posts getPosts(Long userId);

    List<PostsResponseDto.Posts> getAllPosts(Long userId);

    PostsResponseDto.Create createPosts(PostsRequestDto.Create create);

    PostsResponseDto.Create createPostsByForm(PostsRequestDto.Create create);
}
