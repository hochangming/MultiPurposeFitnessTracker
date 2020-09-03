package com.example.Fitness_tracker;

public class BMI_display {
    public String BMI_display(float bmiVal) {
        String bmiVal_label = "";
        if (Float.compare(bmiVal, 15f) <= 0) {
            bmiVal_label = "very_severely_underweight";
        } else if (Float.compare(bmiVal, 15f) > 0 && Float.compare(bmiVal, 16f) <= 0) {
            bmiVal_label = "very_underweight";
        } else if (Float.compare(bmiVal, 16f) > 0 && Float.compare(bmiVal, 18.5f) <= 0) {
            bmiVal_label = "underweight";
        } else if (Float.compare(bmiVal, 18.5f) > 0 && Float.compare(bmiVal, 25f) <= 0) {
            bmiVal_label = "normal";
        } else if (Float.compare(bmiVal, 25f) > 0 && Float.compare(bmiVal, 30f) <= 0) {
            bmiVal_label = "overweight";
        } else if (Float.compare(bmiVal, 30f) > 0 && Float.compare(bmiVal, 35f) <= 0) {
            bmiVal_label = "obese";
        } else if (Float.compare(bmiVal, 35f) > 0 && Float.compare(bmiVal, 40f) <= 0) {
            bmiVal_label = "very obese";
        } else {
            bmiVal_label = "severe obesity";
        }
        bmiVal_label = bmiVal + "\n\n" + bmiVal_label;
        return bmiVal_label;
    }
}
