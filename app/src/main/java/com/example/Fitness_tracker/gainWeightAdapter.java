package com.example.Fitness_tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class gainWeightAdapter extends RecyclerView.Adapter<gainWeightAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<Post> gainWeightPosts = new ArrayList<>();

    public gainWeightAdapter(Context context, ArrayList<Post> gainWeightPosts) {
        this.gainWeightPosts = gainWeightPosts;
        this.context = context;
    }

    @NonNull
    @Override
    public gainWeightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gain_weight_item, parent, false);
        return new gainWeightAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull gainWeightAdapter.ViewHolder holder, int position) {
        holder.gainweightName.setText(gainWeightPosts.get(position).getName());
        holder.gainweightDesc.setText(gainWeightPosts.get(position).getDesc());
        Picasso.get().load(gainWeightPosts.get(position).getImage()).into(holder.gainweightImage);
    }

    @Override
    public int getItemCount() {
        return gainWeightPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView gainweightImage;
        private TextView gainweightName, gainweightDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gainweightImage = itemView.findViewById(R.id.gain_weight_image);
            gainweightName = itemView.findViewById(R.id.gain_weight_name);
            gainweightDesc = itemView.findViewById(R.id.gain_weight_desc);
        }

    }
}
