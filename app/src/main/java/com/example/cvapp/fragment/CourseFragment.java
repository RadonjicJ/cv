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
import com.example.cvapp.adapter.CourseAdapter;
import com.example.cvapp.entity.Course;

import java.util.ArrayList;

public class CourseFragment extends Fragment {

    private RecyclerView recyclerView;
    private CourseAdapter adapter;

    private Context context;
    private ArrayList<Course> courseArrayList;

    public CourseFragment() {
    }

    public CourseFragment(Context context, ArrayList<Course> courseArrayList) {
        this.context = context;
        this.courseArrayList = courseArrayList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.courseRecView);
        adapter = new CourseAdapter(context, courseArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }
}