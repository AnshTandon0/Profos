package com.example.profosassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.profosassignment.R;
import com.example.profosassignment.classes.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Category> categoryList = new ArrayList<>();
    private Click_listener click_listener;

    public CategoryRecyclerAdapter ( Context context , List<Category> categoryList , Click_listener click_listener )
    {
        layoutInflater = LayoutInflater.from(context);
        this.categoryList = categoryList;
        this.click_listener = click_listener;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.category_recycler_view,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull CategoryRecyclerAdapter.CategoryViewHolder holder, int position) {

        holder.textView1.setText(categoryList.get(position).getName());
        if ( !categoryList.get(position).getImageUrl().equalsIgnoreCase("") )
        {
            Glide.with(holder.imageView1)
                    .asBitmap()
                    .load(categoryList.get(position).getImageUrl())
                    .into(holder.imageView1);
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView1 ;
        private TextView textView1 ;

        public CategoryViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.imageView1);
            textView1 = itemView.findViewById(R.id.textView1);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            click_listener.open_sub(getAdapterPosition());
        }
    }

    public interface Click_listener{
        void open_sub( int a );
    }

}
