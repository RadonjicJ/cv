package com.example.cvapp.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "work_experience")
public class WorkExperience {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String company;
    private String date;
    private String description;

    @Ignore
    public WorkExperience() {
    }

    public WorkExperience(String title, String company, String date, String description) {
        this.title = title;
        this.company = company;
        this.date = date;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
