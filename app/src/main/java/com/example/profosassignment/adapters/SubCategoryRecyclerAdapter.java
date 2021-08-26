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
import com.example.profosassignment.classes.Item;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryRecyclerAdapter extends RecyclerView.Adapter<SubCategoryRecyclerAdapter.SubCategoryViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Item> categoryList = new ArrayList<>();
    private Click_listener click_listener;


    public SubCategoryRecyclerAdapter(Context context , List<Item> items , Click_listener click_listener)
    {
        layoutInflater = LayoutInflater.from(context);
        this.categoryList = items;
        this.click_listener = click_listener;
    }

    @NonNull
    @NotNull
    @Override
    public SubCategoryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.sub_category_recycler_view,parent,false);
        return new SubCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SubCategoryRecyclerAdapter.SubCategoryViewHolder holder, int position) {

        holder.name.setText(categoryList.get(position).getName());
        holder.price.setText(String.valueOf(categoryList.get(position).getPrice()));
        if ( !categoryList.get(position).getImageUrl().get(0).equalsIgnoreCase("") )
        {
            Glide.with(holder.imageView)
                    .asBitmap()
                    .load(categoryList.get(position).getImageUrl().get(0))
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class SubCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView name , price;

        public SubCategoryViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView1);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            click_listener.open_item(getAdapterPosition());
        }
    }

    public interface Click_listener{

        void open_item( int a );

    }
}
