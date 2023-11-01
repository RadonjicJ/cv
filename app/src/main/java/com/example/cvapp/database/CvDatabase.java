package com.example.cvapp.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cvapp.dao.CvDAO;
import com.example.cvapp.entity.Course;
import com.example.cvapp.entity.Education;
import com.example.cvapp.entity.Language;
import com.example.cvapp.entity.Profile;
import com.example.cvapp.entity.Skill;
import com.example.cvapp.entity.WorkExperience;

@Database(entities = {Course.class, Education.class, Language.class, Profile.class, Skill.class, WorkExperience.class}, version = 1)
public abstract class CvDatabase extends RoomDatabase {
    private static final String TAG = "CvDatabase";
    private static CvDatabase instance;

    public abstract CvDAO cvDAO();

    public static synchronized CvDatabase getInstance(Context context) {
        Log.d(TAG, "getInstance: " + instance);
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), CvDatabase.class, "my_data")
                    .createFromAsset("databases/my_data.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}
