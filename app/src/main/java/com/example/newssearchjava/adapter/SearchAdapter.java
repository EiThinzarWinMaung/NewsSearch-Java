package com.example.newssearchjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newssearchjava.R;
import com.example.newssearchjava.model.topheadlines.ArticlesItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<ArticlesItem> itemList = new ArrayList<>();

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_everything, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.title.setText(itemList.get(position).getTitle());
        Picasso.get().load(itemList.get(position).getUrlToImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void updateEverything(List<ArticlesItem> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtEverythingTitle);
            image = itemView.findViewById(R.id.imgEverythingImage);
        }
    }
}
