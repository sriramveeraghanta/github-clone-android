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
import com.example.githubclone.models.UserGistModel;

import java.util.List;

public class GistAdapter extends RecyclerView.Adapter<GistAdapter.ViewHolder> {

    private List<UserGistModel> userGists;

    public GistAdapter(List<UserGistModel> gistsList) {
        this.userGists = gistsList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.gist_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(userGists.get(position));
    }

    @Override
    public int getItemCount() {
        return userGists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public UserGistModel userGist;

        public TextView gistIdTextView;
        public TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gistIdTextView = itemView.findViewById(R.id.gist_id_textView);
            descriptionTextView = itemView.findViewById(R.id.gist_description_textView);
        }

        public void bind(UserGistModel userGist){
            Log.v("GITDES", userGist.getDescription());
            this.userGist = userGist;
            gistIdTextView.setText(userGist.getId());
            descriptionTextView.setText(userGist.getDescription());
        }

    }
}
