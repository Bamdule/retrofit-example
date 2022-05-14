package com.example.retrofit.presentaion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retrofit.application.PostsFacade;
import com.example.retrofit.domain.PostsInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostsApiController {

    private final PostsFacade postsFacade;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<PostsResponse.Posts> getPostsByUserId(@PathVariable(value = "userId") Long userId) {

        PostsInfo.Posts posts = postsFacade.getPosts(userId);
        return ResponseEntity.ok(PostsResponse.Posts.of(posts));
    }
}
