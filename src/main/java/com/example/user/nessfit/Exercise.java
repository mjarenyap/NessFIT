package mobapde.machineproject.nessfit;
//package com.example.user.nessfit;

public class Exercise {
    public static final String TABLE_NAME = "exercise";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_PHOTO = "photo_url";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_DIFFICULTY = "difficulty";

    private long id;
    private String name;
    private String description;
    private int photo_url;
    private String category;
    private String difficulty;

    public Exercise(){}

    public Exercise(String name, String description, int photo_url, String category, String difficulty) {
        this.name = name;
        this.description = description;
        this.photo_url = photo_url;
        this.category = category;
        this.difficulty = difficulty;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(int photo_url) {
        this.photo_url = photo_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
