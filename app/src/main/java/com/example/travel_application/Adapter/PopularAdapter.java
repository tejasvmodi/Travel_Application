package com.example.travel_application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travel_application.Domain.ItemDomain;
import com.example.travel_application.databinding.ViewholderPopularBinding;
import com.example.travel_application.databinding.ViewholderRecommendedBinding;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<ItemDomain> items;
    Context context;

    public PopularAdapter(ArrayList<ItemDomain> list) {
        this.items = list;
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderPopularBinding binding = ViewholderPopularBinding.inflate(inflater, parent, false);
        context = parent.getContext();
        return new PopularAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        ItemDomain item = items.get(position);
        holder.binding.titleTxt.setText(item.getTitle());
        holder.binding.PriceTxt.setText("$"+item.getPrice());
        holder.binding.AddressTxt.setText(item.getAddress());
        holder.binding.ScoreText.setText(" " + item.getScore());

        Glide.with(context)
                .load(item.getPic())
                .into(holder.binding.picpopular2);
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderPopularBinding binding;

        public ViewHolder(@NonNull ViewholderPopularBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
