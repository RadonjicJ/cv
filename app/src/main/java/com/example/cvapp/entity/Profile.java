package com.example.cvapp.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Profile {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String email;
    private String number;
    private String address;
    @ColumnInfo(name = "short_description")
    private String shortDescription;
    private String description;
    private String image;
    @ColumnInfo(name = "linkedin_link")
    private String linkedinLink;
    @ColumnInfo(name = "git_link")
    private String gitLink;

    @Ignore
    public Profile() {
    }

    public Profile(String name, String email, String number, String address, String shortDescription, String description, String image) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.address = address;
        this.shortDescription = shortDescription;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }
}
