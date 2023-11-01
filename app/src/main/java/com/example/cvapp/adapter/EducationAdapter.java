package com.example.cvapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cvapp.R;
import com.example.cvapp.databinding.EducationListItemBinding;
import com.example.cvapp.entity.Education;

import java.util.ArrayList;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.EducationViewHolder> {

    private Context context;
    private ArrayList<Education> educationArrayList;

    public EducationAdapter(Context context, ArrayList<Education> educationArrayList) {
        this.context = context;
        this.educationArrayList = educationArrayList;
    }

    @NonNull
    @Override
    public EducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        EducationListItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.education_list_item, parent, false);
        return new EducationViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationViewHolder holder, int position) {
        Education education = educationArrayList.get(position);
        holder.educationListItemBinding.setEducation(education);
    }

    @Override
    public int getItemCount() {
        return educationArrayList.size();
    }


    public class EducationViewHolder extends RecyclerView.ViewHolder {
        EducationListItemBinding educationListItemBinding;

        public EducationViewHolder(EducationListItemBinding educationListItemBinding) {
            super(educationListItemBinding.getRoot());
            this.educationListItemBinding = educationListItemBinding;
        }
    }
}
