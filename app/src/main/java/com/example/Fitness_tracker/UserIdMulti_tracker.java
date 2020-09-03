package com.example.Fitness_tracker;

public class UserIdMulti_tracker {
    private String name;
    private int timeTaken;
    private int reps;
    private int sets;

    public UserIdMulti_tracker(String name, int sets, int reps, int timeTaken) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.timeTaken = timeTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getsets() {
        return sets;
    }

    public void setsets(int weight) {
        this.sets = sets;
    }

    public int gettimeTaken() {
        return timeTaken;
    }

    public int getreps() {
        return reps;
    }

    @Override
    public String toString() {
        return timeTaken + "";
    }
}
