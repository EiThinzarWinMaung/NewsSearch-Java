package com.example.newssearchjava.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newssearchjava.api.ApiService;
import com.example.newssearchjava.model.Everything;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewmodel extends ViewModel {

    MutableLiveData<Everything> results = new MutableLiveData<>();

    public MutableLiveData<Everything> getResults() {
        return results;
    }

    public void loadResults(String searchItem) {

        String apiKey = "b90dd3c699c94e97944d7cc600740c26";

        Call<Everything> callEverything = ApiService.getEverything(searchItem, apiKey);

        callEverything.enqueue(new Callback<Everything>() {
            @Override
            public void onResponse(Call<Everything> call, Response<Everything> response) {
                if(response.isSuccessful() && response.body() != null) {
                    results.setValue(response.body());
                    Log.d("Success >>>>>>>", response.toString());
                }
            }

            @Override
            public void onFailure(Call<Everything> call, Throwable t) {
                Log.d("Error >>>>>>>", t.toString());
            }
        });
    }
}
