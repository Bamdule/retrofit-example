package com.example.retrofit.infrastructure.posts;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.retrofit.exception.RetrofitNoBodyException;
import com.example.retrofit.infrastructure.common.retrofit.CommonApiExecutor;
import com.example.retrofit.infrastructure.posts.retrofit.api.PostsAPI;
import com.example.retrofit.infrastructure.posts.retrofit.dto.PostsRequest;
import com.example.retrofit.infrastructure.posts.retrofit.dto.PostsResponse;

import lombok.RequiredArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiredArgsConstructor
@Component
public class PostsCallerImpl implements PostsCaller {

    private final PostsAPI postsAPI;
    private final CommonApiExecutor apiExecutor;

    @Override
    public PostsResponse.Posts getPosts(Long userId) {
        Call<PostsResponse.Posts> call = postsAPI.getPosts(userId);

        return apiExecutor.execute(call)
            .orElseThrow(RetrofitNoBodyException::new);

    }

    @Override
    public List<PostsResponse.Posts> getAllPosts(Long userId) {
        Call<List<PostsResponse.Posts>> call = postsAPI.getAllPosts(userId);
        return apiExecutor.execute(call)
            .orElseThrow(RetrofitNoBodyException::new);
    }

    @Override
    public PostsResponse.Create createPosts(PostsRequest.Create create) {
        Call<PostsResponse.Create> call = postsAPI.createPosts(create);
        return apiExecutor.execute(call)
            .orElseThrow(RetrofitNoBodyException::new);
    }

    @Override
    public PostsResponse.Create createPostsByFormUrlEncoded(PostsRequest.Create create) {
        Call<PostsResponse.Create> call = postsAPI.createPostsByFormUrlEncoded(
            create.getUserId(),
            create.getTitle(),
            create.getBody()
        );

        return apiExecutor.execute(call)
            .orElseThrow(RetrofitNoBodyException::new);
    }

    /**
     * 비동기 API 호출할 경우 사용한다.
     * @param create
     */
    public void createPostsByAsync(PostsRequest.Create create) {
        Call<PostsResponse.Create> call = postsAPI.createPosts(create);

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<PostsResponse.Create> call, Response<PostsResponse.Create> response) {
                if (response.isSuccessful()) {
                    PostsResponse.Create create = response.body();
                } else {
                    throw new RuntimeException(response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<PostsResponse.Create> call, Throwable t) {
                throw new RuntimeException(t.getMessage());
            }
        });
    }
}
