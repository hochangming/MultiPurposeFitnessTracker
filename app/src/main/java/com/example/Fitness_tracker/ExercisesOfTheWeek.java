package com.example.Fitness_tracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExercisesOfTheWeek extends AppCompatActivity {
    ArrayList<Post> Posts=new ArrayList<>();
    private ExercisesAdapter exercisesAdapter;
    private RecyclerView exercise_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_of_the_week);

        exercise_recyclerView=(RecyclerView)findViewById(R.id.exercise_recyclerView);
        // use a linear layout manager
        exercise_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getExercisesResponse();

    }

    private void getExercisesResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/playpro10/track/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi requestInteface=retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call=requestInteface.getExercisesJson();
//     Asynchronously send the request and notify {@code callback} of its response or if an error
//   * occurred talking to the server, creating the request, or processing the response.
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Posts=new ArrayList<>(response.body());
                exercisesAdapter=new ExercisesAdapter(ExercisesOfTheWeek.this,Posts);
                exercise_recyclerView.setAdapter(exercisesAdapter);
                Toast.makeText(ExercisesOfTheWeek.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(ExercisesOfTheWeek.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}