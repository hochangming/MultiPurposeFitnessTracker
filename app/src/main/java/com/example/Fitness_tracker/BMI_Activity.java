package com.example.Fitness_tracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI_Activity extends AppCompatActivity {
    private EditText weight;
    private EditText height;
    private TextView result_BMI;
    private Button button1;
    private Button button2;
    BMI_display bmi_display = new BMI_display();
    private float bmiVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i_);
        weight = findViewById(R.id.editText1);
        height = findViewById(R.id.editText2);
        result_BMI = (TextView) findViewById(R.id.result);
        button1 = findViewById(R.id.button001);
        button2 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _weight = weight.getText().toString();
                String _height = height.getText().toString();

                if (!_height.equals("")
                        && !_weight.equals("")) {
                    float heightVal = Float.parseFloat(_height) / 100;
                    float weightVal = Float.parseFloat(_weight);
                    bmiVal = weightVal / (heightVal * heightVal);
                    bmi_display.BMI_display(bmiVal);
                    result_BMI.setText(bmi_display.BMI_display(bmiVal));
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public float getBMI() {
        return bmiVal;
    }

}