package com.example.travel_application.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.example.travel_application.Adapter.CategoryAdaptor;
import com.example.travel_application.Adapter.RecommendedAdapter;
import com.example.travel_application.Domain.Category;
import com.example.travel_application.Domain.ItemDomain;
import com.example.travel_application.Domain.Location;
import com.example.travel_application.Adapter.SliderAdapter;
import com.example.travel_application.Domain.SliderItems;
import com.example.travel_application.R;
import com.example.travel_application.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initLocation();
        initBanner();
        initCategory();
        initRecommendation();

    }

    private void initRecommendation() {
        DatabaseReference myRef = database.getReference("Popular");
        binding.progressBarRecommended.setVisibility(View.VISIBLE);
        ArrayList<ItemDomain> list = new ArrayList<>();

        myRef.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot issue : snapshot.getChildren()) {
                                list.add(issue.getValue(ItemDomain.class));
                                Log.d("recommendedtejasv", "onDataChange: " + list);
                            }
                            if (!list.isEmpty()) {
                                binding.recyclerViewRecommended.setLayoutManager(
                                        new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false)
                                );
                                RecommendedAdapter adapter = new RecommendedAdapter(list);
                                binding.recyclerViewRecommended.setAdapter(adapter);
                            }
                            binding.progressBarRecommended.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    private void initCategory() {

        DatabaseReference myref = database.getReference("Category");
        binding.progressBarCategory.setVisibility(View.VISIBLE);
        ArrayList<Category> list = new ArrayList<>();

        myref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot issue : snapshot.getChildren()) {
                                list.add(issue.getValue(Category.class));
                            }
                            if (!list.isEmpty()) {
                                Log.d("TEJASV", "onDataChange: " + list);
                                binding.recyclerViewCategory.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                                RecyclerView.Adapter<CategoryAdaptor.Viewholder> adapter = new CategoryAdaptor(list);
                                binding.recyclerViewCategory.setAdapter(adapter);
                            }
                            binding.progressBarCategory.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    private void initLocation() {
        DatabaseReference myref = database.getReference("Location");
        ArrayList<Location> list = new ArrayList<>();
        myref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot issue : snapshot.getChildren()) {
                                list.add(issue.getValue(Location.class));
                            }
                            ArrayAdapter<Location> adpater = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
                            adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            binding.locationsp.setAdapter(adpater);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }
        );
    }

    private void banners(ArrayList<SliderItems> items) {

        binding.ViewPagerSlider.setAdapter(new SliderAdapter(items, binding.ViewPagerSlider));
        binding.ViewPagerSlider.setClipToPadding(false);
        binding.ViewPagerSlider.setClipChildren(false);
        binding.ViewPagerSlider.setOffscreenPageLimit(3);
        binding.ViewPagerSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        binding.ViewPagerSlider.setPageTransformer(compositePageTransformer);
    }

    public void initBanner() {
        DatabaseReference myrtle = database.getReference("Banner");
        binding.progressBar.setVisibility(View.VISIBLE);
        ArrayList<SliderItems> items = new ArrayList<>();
        myrtle.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot issue : snapshot.getChildren()) {
                                items.add(issue.getValue(SliderItems.class));
                            }
                            banners(items);
                            binding.progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }
        );
    }
}