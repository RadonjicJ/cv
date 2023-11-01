package com.example.cvapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cvapp.R;
import com.example.cvapp.databinding.WorkListItemBinding;
import com.example.cvapp.entity.WorkExperience;

import java.util.ArrayList;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {

    private Context context;
    private ArrayList<WorkExperience> workExperiencesList;

    public WorkAdapter(Context context, ArrayList<WorkExperience> workExperiencesList) {
        this.context = context;
        this.workExperiencesList = workExperiencesList;
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WorkListItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.work_list_item, parent, false);
        return new WorkViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {
        WorkExperience workExperience = workExperiencesList.get(position);
        holder.workListItemBinding.setWork(workExperience);
    }

    @Override
    public int getItemCount() {
        return workExperiencesList.size();
    }

    public class WorkViewHolder extends RecyclerView.ViewHolder {
        WorkListItemBinding workListItemBinding;

        public WorkViewHolder(WorkListItemBinding workListItemBinding) {
            super(workListItemBinding.getRoot());
            this.workListItemBinding = workListItemBinding;
        }
    }
}
