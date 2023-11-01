package com.example.cvapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cvapp.R;
import com.example.cvapp.adapter.EducationAdapter;
import com.example.cvapp.entity.Education;

import java.util.ArrayList;


public class EducationFragment extends Fragment {
    private static final String TAG = "EducationFragment";
    private EducationAdapter adapter;
    private RecyclerView recyclerView;

    private Context context;
    private ArrayList<Education> educations;


    public EducationFragment() {
    }

    public EducationFragment(Context context, ArrayList<Education> educations) {
        this.educations = educations;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.educationRecView);
        adapter = new EducationAdapter(context, educations);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }
}