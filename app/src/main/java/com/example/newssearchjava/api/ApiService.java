package com.example.newssearchjava.api;

import com.example.newssearchjava.model.Everything;

import retrofit2.Call;

public class ApiService {

    public static ApiInterface apiInterface;

    public static ApiInterface getApiInterface() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        return apiInterface;
    }

    public static Call<Everything> getEverything(String searchItem, String apiKey) {
        return ApiService.getApiInterface().getEverything(searchItem, apiKey);
    }
}
