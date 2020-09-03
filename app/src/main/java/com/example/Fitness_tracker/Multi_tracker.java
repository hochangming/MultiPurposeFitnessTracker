package com.example.Fitness_tracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Multi_tracker extends AppCompatActivity {
    Button addData;
    Button reset;
    DataBaseHelper db = new DataBaseHelper(this);
    private EditText SetsInput;
    private EditText repsInput;
    private EditText timeTakenInput;
    private EditText name_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_tracker);
        addData = findViewById(R.id.addData);
        reset = findViewById(R.id.resetButton);

        SetsInput = findViewById(R.id.setsInput);
        repsInput = findViewById(R.id.RepsInput);
        name_ = findViewById(R.id.nameText_);
        timeTakenInput = findViewById(R.id.TimeTakenInput);

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(SetsInput.getText())
                        || !TextUtils.isEmpty(repsInput.getText())
                        || !TextUtils.isEmpty(timeTakenInput.getText())
                        || !TextUtils.isEmpty(name_.getText())) {
                    int SetsInput_ = Integer.parseInt(SetsInput.getText().toString());
                    int repsInput_ = Integer.parseInt(repsInput.getText().toString());
                    int timeTakenInput_ = Integer.parseInt(timeTakenInput.getText().toString());
                    addData(name_.getText().toString(), SetsInput_, repsInput_, timeTakenInput_);

                    Intent intent = new Intent(Multi_tracker.this, DatabaseTableMultiTracker.class);
                    startActivity(intent);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetsInput.setText("");
                repsInput.setText("");
                name_.setText("");
                timeTakenInput.setText("");
            }
        });
    }

    private void addData(String name_, int SetsInput_, int repsInput, int timeTaken) {

        boolean insert = db.insert_Data(name_, SetsInput_, repsInput, timeTaken);
        if (insert) {
            Toast.makeText(Multi_tracker.this, "Entered Data", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Multi_tracker.this, "Something Went Wrong", Toast.LENGTH_LONG).show();
        }
    }
}