package com.example.Fitness_tracker;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GainWeightActivity extends AppCompatActivity {
    ArrayList<Post> posts = new ArrayList<>();
    private gainWeightAdapter gainWeightAdapter;
    private RecyclerView gainWeightRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_weight);
        gainWeightRecyclerview = findViewById(R.id.gain_weight_RecyclerView);
        gainWeightRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        getgainWeightResponse();
    }

    private void getgainWeightResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/playpro10/track1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi requestInterface = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = requestInterface.getGainWeightFood();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                posts = new ArrayList<>(response.body());
                gainWeightAdapter = new gainWeightAdapter(GainWeightActivity.this, posts);
                gainWeightRecyclerview.setAdapter(gainWeightAdapter);
                Toast.makeText(GainWeightActivity.this, "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(GainWeightActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}