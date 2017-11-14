package mobapde.machineproject.nessfit;
//package com.example.user.nessfit;

public class Routine {
    public final static String TABLE_NAME = "routine";
    public final static String COLUMN_ID = "_id";
    public final static String COLUMN_DAY = "day";
    public final static String COLUMN_EXERCISE_ID = "exercise_id";

    private String day;
    private long exercise_id;
    private long id;

    public Routine() {}

    public Routine(String day, long exercise_id) {
        this.day = day;
        this.exercise_id = exercise_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
