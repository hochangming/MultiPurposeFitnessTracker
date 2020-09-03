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

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ViewHolder> {

    private ArrayList<Post> Posts = new ArrayList<>();
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ExercisesAdapter(Context context, ArrayList<Post> Posts) {
        this.Posts = Posts;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ExercisesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create a new view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercises_list_item, viewGroup, false);
        return new ExercisesAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ExercisesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.exercise_name.setText(Posts.get(i).getName()); //bind view
        viewHolder.exercise_desc.setText(Posts.get(i).getDesc());
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Picasso.get().load(Posts.get(i).getImage()).into(viewHolder.exercise_image);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return Posts.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView exercise_image;
        private TextView exercise_name, exercise_desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            exercise_image = (ImageView) itemView.findViewById(R.id.exercise_image);
            exercise_name = (TextView) itemView.findViewById(R.id.exercise_name);
            exercise_desc = (TextView) itemView.findViewById(R.id.exercise_desc);
        }
    }
}
