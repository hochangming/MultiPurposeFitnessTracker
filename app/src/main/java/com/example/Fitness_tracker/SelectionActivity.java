package com.example.Fitness_tracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        Button button1 = findViewById(R.id.Button01);
        Button button2 = findViewById(R.id.Button02);
        Button button3 = findViewById(R.id.Button03);
        Button button4 = findViewById(R.id.Button04);
        Button button5 = findViewById(R.id.Button05);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button01:
                Toast.makeText(getApplicationContext(), "Accessing...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SelectionActivity.this, BMI_Activity.class);
                startActivity(intent);
                break;
            case R.id.Button02:
                Toast.makeText(getApplicationContext(), "Accessing...", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(SelectionActivity.this, Calorie_Activity.class);
                startActivity(intent2);
                break;
            case R.id.Button03:
                Toast.makeText(getApplicationContext(), "Accessing...", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(SelectionActivity.this, Food_Of_The_Week.class);
                startActivity(intent3);
                break;
            case R.id.Button04:
                Toast.makeText(getApplicationContext(), "Accessing...", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(SelectionActivity.this, ExercisesOfTheWeek.class);
                startActivity(intent4);
                break;

                case R.id.Button05:
                Toast.makeText(getApplicationContext(),"Accessing...",Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(SelectionActivity.this,Multi_tracker.class);
                startActivity(intent5);
                break;


        }
    }
}