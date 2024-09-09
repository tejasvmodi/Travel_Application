package com.example.travel_application.Domain;

import androidx.annotation.NonNull;

public class Category {
    private int id;
    private String ImagePath;
    private String Name;

    // Default constructor required for Firebase deserialization
    public Category() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    // Override toString() for meaningful output during debugging
    @NonNull
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", Imagepath='" + ImagePath + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
