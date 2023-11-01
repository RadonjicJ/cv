package com.example.cvapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.cvapp.R;
import com.example.cvapp.adapter.LanguageAdapter;
import com.example.cvapp.adapter.SkillAdapter;
import com.example.cvapp.databinding.FragmentProfileBinding;
import com.example.cvapp.entity.Language;
import com.example.cvapp.entity.Profile;
import com.example.cvapp.entity.Skill;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {
    private static final String TAG = "ProfileFragment";
    private Activity activity;
    private Profile profile;
    private ArrayList<Skill> skillArrayList;
    private ArrayList<Language> languageArrayList;

    private SkillAdapter skillAdapter;
    private LanguageAdapter languageAdapter;

    FragmentProfileBinding profileBinding;

    public ProfileFragment() {

    }

    public ProfileFragment(Activity activity, Profile profile, ArrayList<Skill> skillArrayList, ArrayList<Language> languageArrayList) {
        this.activity = activity;
        this.profile = profile;
        this.skillArrayList = skillArrayList;
        this.languageArrayList = languageArrayList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        profileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        View view = profileBinding.getRoot();
        profileBinding.setProfile(profile);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: profile:" + profile.getName());

        skillAdapter = new SkillAdapter(activity, skillArrayList);
        profileBinding.skillRecView.setLayoutManager(new LinearLayoutManager(activity));
        profileBinding.skillRecView.setAdapter(skillAdapter);

        languageAdapter = new LanguageAdapter(activity, languageArrayList);
        profileBinding.languageRecView.setLayoutManager(new LinearLayoutManager(activity));
        profileBinding.languageRecView.setAdapter(languageAdapter);


    }
}