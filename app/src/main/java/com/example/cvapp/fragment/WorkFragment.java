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
import com.example.cvapp.adapter.WorkAdapter;
import com.example.cvapp.entity.WorkExperience;

import java.util.ArrayList;


public class WorkFragment extends Fragment {

    private RecyclerView recyclerView;
    private WorkAdapter adapter;

    private Context context;
    private ArrayList<WorkExperience> experiences;

    public WorkFragment() {
    }

    public WorkFragment(Context context, ArrayList<WorkExperience> experiences) {
        this.context = context;
        this.experiences = experiences;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.workRecView);
        adapter = new WorkAdapter(context, experiences);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }
}