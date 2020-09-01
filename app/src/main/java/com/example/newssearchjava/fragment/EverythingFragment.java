package com.example.newssearchjava.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.newssearchjava.R;
import com.example.newssearchjava.adapter.SearchAdapter;
import com.example.newssearchjava.viewmodel.SearchViewmodel;

public class EverythingFragment extends Fragment {

    RecyclerView recyclerView;
    SearchViewmodel searchViewmodel = new SearchViewmodel();
    SearchAdapter searchAdapter = new SearchAdapter();

    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_everything, container, false);

        View root = inflater.inflate(R.layout.fragment_everything, container, false);
        recyclerView = root.findViewById(R.id.recyclerviewEverything);

        searchViewmodel = new ViewModelProvider(this).get(SearchViewmodel.class);
//        searchViewmodel.loadResults();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(searchAdapter);

        searchViewmodel.getResults().observe(getViewLifecycleOwner(), item -> {
            searchAdapter.updateEverything(item.getArticles());
        });
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

        if(searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }

        if(searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            searchView.setQueryHint("Search Latest News...");
            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    Log.i("onQueryTextSubmit", s);
                    searchViewmodel.loadResults(s);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.i("onQueryTextChange", s);
                    return false;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
    }
}