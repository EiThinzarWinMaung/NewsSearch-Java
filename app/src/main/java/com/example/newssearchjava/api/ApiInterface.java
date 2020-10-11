package com.example.newssearchjava.api;

import com.example.newssearchjava.model.topheadlines.TopHeadlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<TopHeadlines> getAllNews (
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<TopHeadlines> getSearchNews (
            @Query("q") String searchItem,
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
