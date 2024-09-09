package com.example.travel_application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travel_application.Domain.Category;
import com.example.travel_application.R;
import com.example.travel_application.databinding.ViewholderCategoryBinding;

import java.util.List;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.Viewholder> {
    private final List<Category> items;
    private int selectedPosition = 0;
    private int lastselectedPosition = 1;
    private Context context;

    public CategoryAdaptor(List<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdaptor.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewholderCategoryBinding binding = ViewholderCategoryBinding.inflate(inflater, parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int  position) {
        Category item = items.get(holder.getAbsoluteAdapterPosition());

        // Safely set the title
        if (item.getName() != null) {
            holder.binding.title.setText(item.getName());
        } else {
            holder.binding.title.setText("No name"); // Fallback text
        }

        // Load the image safely using Glide, with placeholders for loading and errors
        if (item.getImagePath() != null && !item.getImagePath().isEmpty()) {
            Glide.with(holder.itemView.getContext())
                    .load(item.getImagePath())
                    .error(R.drawable.ic_launcher_foreground) // Fallback image on error
                    .into(holder.binding.pic);
        } else {
            holder.binding.pic.setImageResource(R.drawable.ic_launcher_background); // Fallback if image URL is missing
        }

        // Handle the category selection logic
        holder.binding.getRoot().setOnClickListener(v -> {
            lastselectedPosition = selectedPosition;
            selectedPosition = position;
            notifyItemChanged(lastselectedPosition); // Rebind last selected item
            notifyItemChanged(selectedPosition); // Rebind current selected item
        });

        // UI updates based on selection
        if (selectedPosition == position) {
            holder.binding.pic.setBackgroundResource(0);
//            holder.binding.MainLayout.setBackgroundResource(R.drawable.blue_bg); // Selected background
            holder.binding.title.setVisibility(View.VISIBLE); // Show title for selected
        } else {
            holder.binding.pic.setBackgroundResource(R.drawable.grey_bg); // Unselected background
            holder.binding.MainLayout.setBackgroundResource(0); // Default background
            holder.binding.title.setVisibility(View.GONE); // Hide title for unselected
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // ViewHolder class to bind views
    public class Viewholder extends RecyclerView.ViewHolder {
        private final ViewholderCategoryBinding binding;

        public Viewholder(ViewholderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
