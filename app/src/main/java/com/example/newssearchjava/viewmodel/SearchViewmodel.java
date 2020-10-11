package com.example.newssearchjava.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newssearchjava.api.ApiService;
import com.example.newssearchjava.model.topheadlines.TopHeadlines;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewmodel extends ViewModel {

    MutableLiveData<TopHeadlines> results = new MutableLiveData<>();

    public MutableLiveData<TopHeadlines> getResults() {
        return results;
    }

    // News All Data
    public void loadAllNews() {
        String apiKey = "b90dd3c699c94e97944d7cc600740c26";
        Call<TopHeadlines> callEverything = ApiService.getAllNews("us", apiKey);
        callEverything.enqueue(new Callback<TopHeadlines>() {
            @Override
            public void onResponse(Call<TopHeadlines> call, Response<TopHeadlines> response) {
                if(response.isSuccessful() && response.body() != null) {
                    results.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<TopHeadlines> call, Throwable t) {
                Log.d("Error >>>>>>>", t.toString());
            }
        });
    }

    // News Search Data
    public void loadSearchNews(String searchItem) {
        String apiKey = "b90dd3c699c94e97944d7cc600740c26";
        Call<TopHeadlines> callEverything = ApiService.getSearchNews(searchItem, "us", apiKey);
        callEverything.enqueue(new Callback<TopHeadlines>() {
            @Override
            public void onResponse(Call<TopHeadlines> call, Response<TopHeadlines> response) {
                if(response.isSuccessful() && response.body() != null) {
                    results.setValue(response.body());
                    Log.d("Success >>>>>>>", response.toString());
                }
            }
            @Override
            public void onFailure(Call<TopHeadlines> call, Throwable t) {
                Log.d("Error >>>>>>>", t.toString());
            }
        });
    }
}
