package com.example.cvapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cvapp.R;
import com.example.cvapp.databinding.ListItemBinding;
import com.example.cvapp.entity.Skill;

import java.util.ArrayList;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillViewHolder> {

    private Context context;
    private ArrayList<Skill> skillArrayList;

    public SkillAdapter(Context context, ArrayList<Skill> skillArrayList) {
        this.context = context;
        this.skillArrayList = skillArrayList;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.list_item, parent, false);
        return new SkillViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        Skill skill = skillArrayList.get(position);
        holder.listItemBinding.listName.setText(skill.getName());
    }

    @Override
    public int getItemCount() {
        return skillArrayList.size();
    }

    public class SkillViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding listItemBinding;

        public SkillViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;
        }
    }
}
