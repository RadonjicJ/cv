package com.example.cvapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.cvapp.entity.Course;
import com.example.cvapp.entity.Education;
import com.example.cvapp.entity.Language;
import com.example.cvapp.entity.Profile;
import com.example.cvapp.entity.Skill;
import com.example.cvapp.entity.WorkExperience;
import com.example.cvapp.repository.CvRepository;

import java.util.List;

public class CvViewModel extends AndroidViewModel {

    private CvRepository repository;


    public CvViewModel(@NonNull Application application) {
        super(application);
        this.repository = new CvRepository(application);
    }

    public LiveData<Profile> getProfile() {
        return repository.getProfile();
    }

    public LiveData<List<Skill>> getSkills() {
        return repository.getAllSkills();
    }

    public LiveData<List<Language>> getLanguages() {
        return repository.getAllLanguages();
    }

    public LiveData<List<Education>> getEducations() {
        return repository.getAllEducation();
    }

    public LiveData<List<WorkExperience>> getWorkExperiences() {
        return repository.getAllWorkExperience();
    }

    public LiveData<List<Course>> getCourses() {
        return repository.getAllCourses();
    }
}
