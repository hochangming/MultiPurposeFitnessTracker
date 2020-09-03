package com.example.Fitness_tracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calorie_Activity extends AppCompatActivity {

    private EditText ageInput;
    private EditText heightInput;
    private EditText weightInput;
    private EditText name;

    private RadioButton zero;
    private RadioButton oneToTwo;
    private RadioButton threeToFive;
    private RadioButton sixToSeven;
    private RadioButton male;
    private RadioButton female;
    public static int weight = 200;
    public static String name_ = "";
    DataBaseHelper myDB;

    TextView displayValue;
    TextView displayValue1;
    TextView displayValue2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_);
        myDB = new DataBaseHelper(this);

        ageInput = (EditText) findViewById(R.id.ageInput);
        name = (EditText) findViewById(R.id.nameText);
        heightInput = (EditText) findViewById(R.id.heightInput);
        weightInput = (EditText) findViewById(R.id.weightInput);

        Button resetButton = findViewById(R.id.resetButton);
        Button addCalorieData = findViewById(R.id.addCalorieData);
        Button viewhistory = findViewById(R.id.viewhistory);

        displayValue = (TextView) findViewById(R.id.displayValue);
        displayValue1 = (TextView) findViewById(R.id.displayValue1);
        displayValue2 = (TextView) findViewById(R.id.displayValue2);

        zero = findViewById(R.id.radioButton1);
        oneToTwo = findViewById(R.id.radioButton2);
        threeToFive = findViewById(R.id.radioButton3);
        sixToSeven = findViewById(R.id.radioButton4);
        male = findViewById(R.id.radioButton5);
        female = findViewById(R.id.radioButton6);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText("");
                displayValue1.setText("");
                displayValue2.setText("");
                ageInput.setText("");
                name.setText("");
                heightInput.setText("");
                weightInput.setText("");

            }
        });

        addCalorieData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = 0;
                double calc_calories = (int) CalculateCalories();
                result = maintainWeight(calc_calories);

                if (!TextUtils.isEmpty(ageInput.getText())
                        || !TextUtils.isEmpty(heightInput.getText())
                        || !TextUtils.isEmpty(weightInput.getText())
                        || !TextUtils.isEmpty(name.getText())) {
                    int _weight = Integer.parseInt(weightInput.getText().toString());
                    int _age = Integer.parseInt(ageInput.getText().toString());
                    displayValue.setText(String.valueOf((int) CutWeight(calc_calories)));
                    displayValue1.setText(String.valueOf((int) result));
                    displayValue2.setText(String.valueOf((int) GainWeight(calc_calories)));
                    AddData(name.getText().toString(), _age, _weight, (int) result);
                }

            }
        });

        viewhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calorie_Activity.this, DatabaseTableCalorie.class);
                startActivity(intent);
            }
        });
    }

    private double GainWeight(double dailycalories) {
        return dailycalories + 500;
    }

    private double CutWeight(double dailycalories) {
        return dailycalories - 500;
    }

    private double maintainWeight(double calc_calories) {
        return calc_calories;
    }

    public double CalculateCalories() {
        double ageNum = 0.0;
        double weightNum = 0.0;
        double heightNum = 0.0;
        double bmr = 0.0;
        int dailyCaloricIntake = 0;
        if (TextUtils.isEmpty(ageInput.getText())
                || TextUtils.isEmpty(heightInput.getText())
                || TextUtils.isEmpty(weightInput.getText())) {
            return -1;
        }

        ageNum = Double.parseDouble(ageInput.getText().toString());
        weightNum = Double.parseDouble(weightInput.getText().toString());
        heightNum = Double.parseDouble(heightInput.getText().toString());

        if (male.isChecked()) {
            bmr = (heightNum * 6.25) + (weightNum * 9.99) - (ageNum * 4.92) + 5;
        } else if (female.isChecked()) {
            bmr = (heightNum * 6.25) + (weightNum * 9.99) - (ageNum * 4.92) - 161;
        }
        if (zero.isChecked()) {
            dailyCaloricIntake = (int) (bmr * 1.2);
        } else if (oneToTwo.isChecked()) {
            dailyCaloricIntake = (int) (bmr * 1.375);
        } else if (threeToFive.isChecked()) {
            dailyCaloricIntake = (int) (bmr * 1.55);
        } else if (sixToSeven.isChecked()) {
            dailyCaloricIntake = (int) (bmr * 1.725);
        }
        return dailyCaloricIntake;
    }

    public void AddData(String name, int age, int weight, int calorieDailyIntake) {
        boolean insert = myDB.InsertData(name, age, weight, calorieDailyIntake);
        if (insert) {
            Toast.makeText(Calorie_Activity.this, "Entered Data", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Calorie_Activity.this, "Something Went Wrong", Toast.LENGTH_LONG).show();
        }
    }


}