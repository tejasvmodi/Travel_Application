package com.example.travel_application.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travel_application.databinding.ActivityIntroBinding;

public class introActivity extends AppCompatActivity {
    ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityIntroBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());
       binding.introBtn.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       startActivity(new Intent(introActivity.this,MainActivity.class));
                   }
               }
       );
    }
}