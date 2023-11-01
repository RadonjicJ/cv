package com.example.cvapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cvapp.R;
import com.example.cvapp.databinding.CourseListItemBinding;
import com.example.cvapp.entity.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;
    private ArrayList<Course> courseArrayList;

    public CourseAdapter(Context context, ArrayList<Course> courseArrayList) {
        this.context = context;
        this.courseArrayList = courseArrayList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CourseListItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.course_list_item, parent, false);
        return new CourseViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courseArrayList.get(position);
        holder.courseListItemBinding.setCourse(course);
    }

    @Override
    public int getItemCount() {
        return courseArrayList.size();
    }


    public class CourseViewHolder extends RecyclerView.ViewHolder {
        CourseListItemBinding courseListItemBinding;

        public CourseViewHolder(CourseListItemBinding courseListItemBinding) {
            super(courseListItemBinding.getRoot());
            this.courseListItemBinding = courseListItemBinding;
        }
    }
}
