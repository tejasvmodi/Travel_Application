package com.example.travel_application;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.travel_application.databinding.ActivityIntroBinding;

public class MainActivity extends BaseActivity {
  ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding = ActivityIntroBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());
      initLocation();
    }

    private void initLocation() {
    }
}