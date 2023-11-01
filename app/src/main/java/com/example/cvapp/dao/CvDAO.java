package com.example.cvapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cvapp.entity.Course;
import com.example.cvapp.entity.Education;
import com.example.cvapp.entity.Language;
import com.example.cvapp.entity.Profile;
import com.example.cvapp.entity.Skill;
import com.example.cvapp.entity.WorkExperience;

import java.util.List;

@Dao
public interface CvDAO {

    @Query("SELECT * FROM profile")
    LiveData<Profile> getProfile();

    @Query("SELECT * FROM education")
    LiveData<List<Education>> getAllEducation();

    @Query("SELECT * FROM work_experience")
    LiveData<List<WorkExperience>> getAllWorkExperience();

    @Query("SELECT * FROM Course")
    LiveData<List<Course>> getAllCourses();

    @Query("SELECT * FROM skill")
    LiveData<List<Skill>> getAllSkills();

    @Query("SELECT * FROM language")
    LiveData<List<Language>> getAllLanguages();

    @Insert
    void populateEducation(Education... educations);
}
