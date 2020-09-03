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

public class loseWeightAdapter extends RecyclerView.Adapter<loseWeightAdapter.ViewHolder> {
    private ArrayList<Post> loseWeightPosts= new ArrayList<>();
    private Context context;

    public loseWeightAdapter(Context context, ArrayList<Post> posts){
        this.loseWeightPosts=posts;
        this.context=context;
    }
    @NonNull
    @Override
    public loseWeightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lose_weight_item,parent,false);
        return new loseWeightAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull loseWeightAdapter.ViewHolder holder, int position) {
        holder.loseweightName.setText(loseWeightPosts.get(position).getName());
        holder.loseweightDesc.setText(loseWeightPosts.get(position).getDesc());
        Picasso.get().load(loseWeightPosts.get(position).getImage()).into(holder.loseweightImage);
    }

    @Override
    public int getItemCount() {
        return loseWeightPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView loseweightImage;
        private TextView loseweightName, loseweightDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            loseweightImage = itemView.findViewById(R.id.lose_weight_image);
            loseweightName = itemView.findViewById(R.id.lose_weight_name);
            loseweightDesc = itemView.findViewById(R.id.lose_weight_desc);
        }

    }
}
