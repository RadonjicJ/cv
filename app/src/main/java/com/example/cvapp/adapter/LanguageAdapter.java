package com.example.cvapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cvapp.R;
import com.example.cvapp.databinding.ListItemBinding;
import com.example.cvapp.entity.Language;

import java.util.ArrayList;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {

    private Context context;
    private ArrayList<Language> languageArrayList;

    public LanguageAdapter(Context context, ArrayList<Language> languageArrayList) {
        this.context = context;
        this.languageArrayList = languageArrayList;
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.list_item, parent, false);
        return new LanguageViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {
        Language language = languageArrayList.get(position);
        holder.listItemBinding.listName.setText(language.getName());
    }

    @Override
    public int getItemCount() {
        return languageArrayList.size();
    }


    public class LanguageViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding listItemBinding;

        public LanguageViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;
        }
    }
}
