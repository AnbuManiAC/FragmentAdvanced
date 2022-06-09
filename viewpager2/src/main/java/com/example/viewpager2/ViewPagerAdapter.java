package com.example.viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    final ArrayList<Integer> imageList;

    public ViewPagerAdapter(ArrayList<Integer> images){
        this.imageList = images;
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder {

        View itemView;

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager , parent, false);
        return new ViewPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        int currentImg = imageList.get(position);

        ImageView imageView = holder.itemView.findViewById(R.id.ivImage);
        imageView.setImageResource(currentImg);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }


}
