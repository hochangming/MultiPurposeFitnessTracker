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

public class LoseWeightActivity extends AppCompatActivity {
    ArrayList<Post> posts = new ArrayList<>();
    private loseWeightAdapter loseWeightAdapter;
    private RecyclerView loseWeightRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight);
        loseWeightRecyclerview = findViewById(R.id.lose_weight_RecyclerView);
        loseWeightRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        getLoseWeightResponse();
    }

    private void getLoseWeightResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/playpro10/demo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi requestInterface = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = requestInterface.getLoseWeightFood();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                posts = new ArrayList<>(response.body());
                loseWeightAdapter = new loseWeightAdapter(LoseWeightActivity.this, posts);
                loseWeightRecyclerview.setAdapter(loseWeightAdapter);
                Toast.makeText(LoseWeightActivity.this, "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(LoseWeightActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}