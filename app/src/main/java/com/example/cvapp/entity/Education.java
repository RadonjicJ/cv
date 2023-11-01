package com.example.cvapp.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class Education {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String school;
    private String description;

    @Ignore
    public Education() {
    }

    public Education(String title, String school, String description) {
        this.title = title;
        this.school = school;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
