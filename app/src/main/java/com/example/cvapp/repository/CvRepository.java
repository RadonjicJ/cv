package com.example.cvapp.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.cvapp.dao.CvDAO;
import com.example.cvapp.database.CvDatabase;
import com.example.cvapp.entity.Course;
import com.example.cvapp.entity.Education;
import com.example.cvapp.entity.Language;
import com.example.cvapp.entity.Profile;
import com.example.cvapp.entity.Skill;
import com.example.cvapp.entity.WorkExperience;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CvRepository {
    private static final String TAG = "CvRepository";
    private final CvDAO cvDAO;
    ExecutorService executorService;
    Handler handler;

    public CvRepository(Application application) {
        CvDatabase database = CvDatabase.getInstance(application);
        this.cvDAO = database.cvDAO();
        executorService = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public LiveData<Profile> getProfile() {
        return cvDAO.getProfile();
    }

    public LiveData<List<Education>> getAllEducation() {
        LiveData<List<Education>> education = cvDAO.getAllEducation();
        return education;
    }

    public LiveData<List<WorkExperience>> getAllWorkExperience() {
        return cvDAO.getAllWorkExperience();
    }

    public LiveData<List<Course>> getAllCourses() {
        return cvDAO.getAllCourses();
    }

    public LiveData<List<Skill>> getAllSkills() {
        return cvDAO.getAllSkills();
    }

    public LiveData<List<Language>> getAllLanguages() {
        return cvDAO.getAllLanguages();
    }
}
