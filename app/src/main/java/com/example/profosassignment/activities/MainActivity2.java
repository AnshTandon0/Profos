package com.example.profosassignment.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.profosassignment.R;
import com.example.profosassignment.adapters.CategoryRecyclerAdapter;
import com.example.profosassignment.adapters.SubCategoryRecyclerAdapter;
import com.example.profosassignment.classes.Category;
import com.example.profosassignment.classes.Item;
import com.example.profosassignment.classes.Review;
import com.example.profosassignment.databinding.ActivityMainYuBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements SubCategoryRecyclerAdapter.Click_listener {

    private ActivityMainYuBinding binding;
    private DatabaseReference databaseReference;
    private ChildEventListener childEventListener;
    private List<Item> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainYuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Category category = (Category) getIntent().getSerializableExtra("category");

        databaseReference = FirebaseDatabase.getInstance().getReference("Items");

        SubCategoryRecyclerAdapter categoryRecyclerAdapter = new SubCategoryRecyclerAdapter(this,stringList,this::open_item);

        binding.recyclerView.setAdapter(categoryRecyclerAdapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                Item item = snapshot.getValue(Item.class);

                for ( int i=1 ; i < category.getItemsId().size() ; i++ )
                {
                    if ( category.getItemsId().get(i).equalsIgnoreCase(item.getId()) )
                    {
                        stringList.add(item);
                        categoryRecyclerAdapter.notifyDataSetChanged();
                    }
                }
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
    public void open_item(int a) {

        Intent intent = new Intent(this, MainActivitySingle.class);
        intent.putExtra("item",stringList.get(a));
        startActivity(intent);

    }
}