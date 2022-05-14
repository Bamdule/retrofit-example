package com.example.retrofit.infrastructure.posts;

import java.util.List;

import com.example.retrofit.infrastructure.posts.retrofit.dto.PostsRequest;
import com.example.retrofit.infrastructure.posts.retrofit.dto.PostsResponse;

public interface PostsCaller {

    PostsResponse.Posts getPosts(Long userId);

    List<PostsResponse.Posts> getAllPosts(Long userId);

    PostsResponse.Create createPosts(PostsRequest.Create create);

    PostsResponse.Create createPostsByFormUrlEncoded(PostsRequest.Create create);
}
