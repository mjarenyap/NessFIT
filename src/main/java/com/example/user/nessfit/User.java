package mobapde.machineproject.nessfit;
// package com.example.user.nessfit;

public class User {

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TRAINING_LEVEL = "training_level";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_GENDER = "gender";

    private long id;
    private String name;
    private String trainingLevel;
    private float weight;
    private String gender;

    public User() {}

    public User(long id, String name, String trainingLevel, float weight, String gender) {
        this.id = id;
        this.name = name;
        this.trainingLevel = trainingLevel;
        this.weight = weight;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
