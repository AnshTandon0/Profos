package com.example.profosassignment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Binder;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.profosassignment.classes.Item;
import com.example.profosassignment.databinding.ActivityMainSingleBinding;

public class MainActivitySingle extends AppCompatActivity {

    private ActivityMainSingleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainSingleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Item item = (Item) getIntent().getSerializableExtra("item");

        binding.name.setText(item.getName());
        binding.price.setText(String.valueOf(item.getPrice()));
        binding.details.setText(item.getDetails());
        if ( !item.getImageUrl().get(0).equalsIgnoreCase("") )
        {
            Glide.with(binding.imageView1)
                    .asBitmap()
                    .load(item.getImageUrl().get(0))
                    .into(binding.imageView1);
        }

    }
}