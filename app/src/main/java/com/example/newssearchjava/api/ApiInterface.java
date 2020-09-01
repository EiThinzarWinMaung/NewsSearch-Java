package com.example.newssearchjava.api;

import com.example.newssearchjava.model.Everything;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("everything")
    Call<Everything> getEverything (
            @Query("q") String searchItem,
            @Query("apiKey") String apiKey
    );
}
