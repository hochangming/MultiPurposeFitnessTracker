package com.example.Fitness_tracker;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Food_Of_The_Week extends AppCompatActivity {
    private TextView result;
    private RequestQueue rqueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__of__the__week);
        final Button LoseWeightbutton = findViewById(R.id.LoseWeightbutton);
        Button GainWeightbutton = findViewById(R.id.GainWeightbutton);
        result = findViewById(R.id.textResult);
        rqueue = Volley.newRequestQueue(this);
        LoseWeightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food_Of_The_Week.this,LoseWeightActivity.class);
                startActivity(intent);
            }
        });
        GainWeightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food_Of_The_Week.this,GainWeightActivity.class);
                startActivity(intent);
            }
        });
    }

}