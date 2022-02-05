package com.example.retrofit;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiredArgsConstructor
@Component
public class PostsCallerImpl implements PostsCaller {

    private final RetrofitUtils retrofitUtils;

    private final PostsAPI postsAPI;

    @Override
    public PostsResponseDto.Posts getPosts(Long userId) {
        Call<PostsResponseDto.Posts> call = postsAPI.getPosts(userId);
        return retrofitUtils.execute(call);
    }

    @Override
    public List<PostsResponseDto.Posts> getAllPosts(Long userId) {
        Call<List<PostsResponseDto.Posts>> call = postsAPI.getAllPosts(userId);
        return retrofitUtils.execute(call);
    }

    @Override
    public PostsResponseDto.Create createPosts(PostsRequestDto.Create create) {
        Call<PostsResponseDto.Create> call = postsAPI.createPosts(create);
        return retrofitUtils.execute(call);
    }

    @Override
    public PostsResponseDto.Create createPostsByForm(PostsRequestDto.Create create) {
        Call<PostsResponseDto.Create> call = postsAPI.createPostsByForm(
            create.getUserId(),
            create.getTitle(),
            create.getBody()
        );

        return retrofitUtils.execute(call);
    }


    public void createPostsByAsync(PostsRequestDto.Create create) {
        Call<PostsResponseDto.Create> call = postsAPI.createPosts(create);

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<PostsResponseDto.Create> call, Response<PostsResponseDto.Create> response) {
                if(response.isSuccessful()){
                    PostsResponseDto.Create create = response.body();
                } else {
                    throw new RuntimeException(response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<PostsResponseDto.Create> call, Throwable t) {
                throw new RuntimeException(t.getMessage());
            }
        });
    }
}
