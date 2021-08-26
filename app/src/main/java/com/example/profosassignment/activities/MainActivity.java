package com.example.profosassignment.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;

import com.example.profosassignment.R;
import com.example.profosassignment.adapters.CategoryRecyclerAdapter;
import com.example.profosassignment.classes.Category;
import com.example.profosassignment.databinding.ActivityMainBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryRecyclerAdapter.Click_listener{

    private ActivityMainBinding binding;
    private DatabaseReference databaseReference;
    private ChildEventListener childEventListener;
    private List<Category> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference = FirebaseDatabase.getInstance().getReference("Category");

        CategoryRecyclerAdapter categoryRecyclerAdapter = new CategoryRecyclerAdapter(this,stringList,this::open_sub);

        binding.recyclerView.setAdapter(categoryRecyclerAdapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this,3));

       childEventListener = new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
               Category category = snapshot.getValue(Category.class);
               stringList.add(category);
               categoryRecyclerAdapter.notifyDataSetChanged();
           }

           @Override
           public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

           }

           @Override
           public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

           }

           @Override
           public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

           }

           @Override
           public void onCancelled(@NonNull @NotNull DatabaseError error) {

           }
       };
       databaseReference.addChildEventListener(childEventListener);

    }

    @Override
    public void open_sub(int a) {

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("category",stringList.get(a));
        Log.d("hhhhhhhhhhhhh",stringList.get(a).getName());
        startActivity(intent);
    }
}