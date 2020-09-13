package com.example.githubclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubclone.R;
import com.example.githubclone.models.Repository;

import java.util.List;

public class StarredAdapter extends RecyclerView.Adapter<StarredAdapter.ViewHolder> {

    private List<Repository> starredRepos;

    public StarredAdapter(List<Repository> repos){
        this.starredRepos = repos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflater the custom layout
        View view = inflater.inflate(R.layout.starred_repos_list_item, parent, false);
        return new StarredAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(starredRepos.get(position));
    }

    @Override
    public int getItemCount() {
        return starredRepos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Repository repository;
        public TextView starredRepoNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            starredRepoNameTextView = itemView.findViewById(R.id.starredRepo_name_textView);
        }
        public void bind(Repository repo){
            this.repository = repo;
            starredRepoNameTextView.setText(repo.getName());
        }
    }



}
