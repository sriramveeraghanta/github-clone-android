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
import com.example.githubclone.models.Gist;

import java.util.Iterator;
import java.util.List;

public class GistAdapter extends RecyclerView.Adapter<GistAdapter.ViewHolder> {

    private List<Gist> userGists;

    public GistAdapter(List<Gist> gistsList) {
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
        if(userGists != null){
            return  userGists.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Gist userGist;

        public TextView gistCommentCountTextView;
        public TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descriptionTextView = itemView.findViewById(R.id.gist_description_textView);
            gistCommentCountTextView = itemView.findViewById(R.id.gist_comments_textView);
        }

        public void bind(Gist userGist){
            this.userGist = userGist;

            Iterator<String> iter =  userGist.getFiles().keys();
            while(iter.hasNext()){
                String key = iter.next();
                Log.v("GIST FILES", key);
            }


            gistCommentCountTextView.setText(userGist.getComments().toString());
            descriptionTextView.setText(userGist.getDescription() + " - "+userGist.getId());
        }
    }
}
