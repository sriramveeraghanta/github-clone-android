package com.example.githubclone.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubclone.R;
import com.example.githubclone.models.Repository;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {
    private List<Repository> repos;

    public RepoAdapter(List<Repository> repos) {
        this.repos = repos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View view = inflater.inflate(R.layout.repo_list_item, parent, false);
        return new RepoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(repos.get(position));
    }

    @Override
    public int getItemCount() {
        if (repos != null) {
            return repos.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Repository repo;

        public TextView repoNameTextView;
        public TextView repoDescriptionTextView;
        public TextView repoForkCountTextView;
        public TextView repoStartCountTextView;
        public TextView repoWatcherCountTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            repoNameTextView = itemView.findViewById(R.id.repo_name_textView);
            repoDescriptionTextView = itemView.findViewById(R.id.repo_description_textView);
            repoForkCountTextView = itemView.findViewById(R.id.repo_forks_textView);
            repoStartCountTextView = itemView.findViewById(R.id.repo_stars_textView);
            repoWatcherCountTextView = itemView.findViewById(R.id.repo_watchers_textView);
        }

        public void bind(Repository repo) {
            this.repo = repo;
            repoNameTextView.setText(repo.getName());
            repoDescriptionTextView.setText(repo.getDescription());
            repoForkCountTextView.setText(repo.getForks_count().toString());
            repoStartCountTextView.setText(repo.getStargazers_count().toString());
            repoWatcherCountTextView.setText(repo.getWatchers().toString());
        }

    }


}
