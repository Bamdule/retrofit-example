package com.example.retrofit.infrastructure.common.retrofit;

import java.util.Optional;

import retrofit2.Call;

public interface RetrofitApiExecutor {
    <T> Optional<T> execute(Call<T> call);
}
