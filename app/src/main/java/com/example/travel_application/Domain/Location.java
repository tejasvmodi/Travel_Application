package com.example.travel_application.Domain;

import androidx.annotation.NonNull;

public class Location {
    private int Id;
    private String loc;

    public Location(){
    }

    @NonNull
    @Override
    public String toString() {
        return loc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
