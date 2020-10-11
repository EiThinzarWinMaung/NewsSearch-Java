package com.example.newssearchjava.api;

import com.example.newssearchjava.model.topheadlines.TopHeadlines;

import retrofit2.Call;

public class ApiService {

    public static ApiInterface apiInterface;

    public static ApiInterface getApiInterface() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        return apiInterface;
    }

    public static Call<TopHeadlines> getAllNews(String country, String apiKey) {
        return ApiService.getApiInterface().getAllNews(country, apiKey);
    }

    public static Call<TopHeadlines> getSearchNews(String searchItem, String country, String apiKey) {
        return ApiService.getApiInterface().getSearchNews(searchItem, country, apiKey);
    }
}
