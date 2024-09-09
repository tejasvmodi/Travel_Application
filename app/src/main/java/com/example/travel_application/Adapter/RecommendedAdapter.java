package com.example.travel_application.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travel_application.Domain.ItemDomain;
import com.example.travel_application.databinding.ViewholderRecommendedBinding;

import java.util.ArrayList;
public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    ArrayList<ItemDomain> items;
    Context context;

    public RecommendedAdapter(ArrayList<ItemDomain> list) {
        this.items = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderRecommendedBinding binding = ViewholderRecommendedBinding.inflate(inflater, parent, false);
        context = parent.getContext();
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemDomain item = items.get(position);
        holder.binding.titleText.setText(item.getTitle());
        holder.binding.Pricetxt.setText("$"+item.getPrice());
        holder.binding.addressTxt.setText(item.getAddress());
        holder.binding.ScoreTxt.setText(" " + item.getScore());

        Glide.with(context)
                .load(item.getPic())
                .into(holder.binding.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderRecommendedBinding binding;

        public ViewHolder(@NonNull ViewholderRecommendedBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
