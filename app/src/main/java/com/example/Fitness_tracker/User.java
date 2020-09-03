package com.example.Fitness_tracker;

public class User {
    private String name;
    private int CalorieDailyIntake;
    private int weight;
    private int age;

    public User(String name, int age, int weight, int calorieDailyIntake) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.CalorieDailyIntake = calorieDailyIntake;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDailyCaloricIntake() {
        return CalorieDailyIntake;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return CalorieDailyIntake + "";
    }
}
