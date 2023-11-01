package com.example.cvapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cvapp.adapter.FragmentAdapter;
import com.example.cvapp.database.CvDatabase;
import com.example.cvapp.entity.Course;
import com.example.cvapp.entity.Education;
import com.example.cvapp.entity.Language;
import com.example.cvapp.entity.Profile;
import com.example.cvapp.entity.Skill;
import com.example.cvapp.entity.WorkExperience;
import com.example.cvapp.fragment.CourseFragment;
import com.example.cvapp.fragment.EducationFragment;
import com.example.cvapp.fragment.ProfileFragment;
import com.example.cvapp.fragment.WorkFragment;
import com.example.cvapp.viewmodel.CvViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String LINKEDIN = "linkedin";
    public static final String GIT = "git";

    private ViewPager2 viewPager;
    private FragmentAdapter adapter;
    private TabLayout tabLayout;

    private CvDatabase database;
    private CvViewModel viewModel;

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private MaterialToolbar toolbar;

    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Education> educations = new ArrayList<>();
    private ArrayList<Language> languages = new ArrayList<>();
    private Profile profile;
    private ArrayList<Skill> skills = new ArrayList<>();
    private ArrayList<WorkExperience> workExperiences = new ArrayList<>();

    TextView headerName;
    TextView headerDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationMenu();

        database = CvDatabase.getInstance(this);
        viewModel = new ViewModelProvider(this).get(CvViewModel.class);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());

        getData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initFragment();
                navigationListener();
            }
        }, 200);

    }

    private void navigationListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.call) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    String uriCall = "tel:" + profile.getNumber();
                    callIntent.setData(Uri.parse(uriCall));
                    startActivity(callIntent);
                } else if (item.getItemId() == R.id.sendMail) {
                    Intent mailIntent = new Intent(Intent.ACTION_SEND);
                    mailIntent.setData(Uri.parse("mailto:"));
                    mailIntent.setType("text/plain");
                    mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{profile.getEmail()});
                    startActivity(mailIntent);
                } else if (item.getItemId() == R.id.linkedin) {
                    Intent linkIntent = new Intent(MainActivity.this, WebActivity.class);
                    linkIntent.putExtra(LINKEDIN, profile.getLinkedinLink());
                    startActivity(linkIntent);
                } else if (item.getItemId() == R.id.git) {
                    Intent gitIntent = new Intent(MainActivity.this, WebActivity.class);
                    gitIntent.putExtra(GIT, profile.getGitLink());
                    startActivity(gitIntent);
                }
                return false;
            }
        });
    }


    private void initFragment() {

        adapter.addFragment(new ProfileFragment(MainActivity.this, profile, skills, languages));
        adapter.addFragment(new EducationFragment(MainActivity.this, educations));
        adapter.addFragment(new WorkFragment(MainActivity.this, workExperiences));
        adapter.addFragment(new CourseFragment(MainActivity.this, courses));

        viewPager.setAdapter(adapter);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        headerName.setText(profile.getName());
        headerDesc.setText(profile.getShortDescription());

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.profile);
                    break;
                case 1:
                    tab.setText(R.string.education);
                    break;
                case 2:
                    tab.setText(R.string.work_experience);
                    break;
                case 3:
                    tab.setText(R.string.courses);
                    break;
            }
        }).attach();

    }

    private void initNavigationMenu() {
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        headerName = findViewById(R.id.headerProfileName);
        headerDesc = findViewById(R.id.headerProfileShorDesc);

        headerName = navigationView.getHeaderView(0).findViewById(R.id.headerProfileName);
        headerDesc = navigationView.getHeaderView(0).findViewById(R.id.headerProfileShorDesc);

    }


    /**
     * in this application it is not necessary to do this, just for practice
     * there is no data change so there is no need to listen for the change and use live data
     */
    private void getData() {

        viewModel.getEducations().observe(this, new Observer<List<Education>>() {
            @Override
            public void onChanged(List<Education> educationList) {
                educations.clear();
                for (Education e : educationList) {
                    educations.add(e);
                }
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.getWorkExperiences().observe(this, new Observer<List<WorkExperience>>() {
            @Override
            public void onChanged(List<WorkExperience> workExperiencesList) {
                workExperiences.clear();
                for (WorkExperience w : workExperiencesList) {
                    workExperiences.add(w);
                }
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.getCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courseList) {
                courses.clear();
                for (Course c : courseList) {
                    courses.add(c);
                }
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.getProfile().observe(MainActivity.this, new Observer<Profile>() {
            @Override
            public void onChanged(Profile profileLive) {
                profile = profileLive;
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.getSkills().observe(this, new Observer<List<Skill>>() {
            @Override
            public void onChanged(List<Skill> skillList) {
                skills.clear();
                for (Skill s : skillList) {
                    skills.add(s);

                }
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.getLanguages().observe(this, new Observer<List<Language>>() {
            @Override
            public void onChanged(List<Language> languageList) {
                languages.clear();
                for (Language l : languageList) {
                    languages.add(l);

                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}