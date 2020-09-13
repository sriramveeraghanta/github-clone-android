package com.example.githubclone.ui.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubclone.R;
import com.example.githubclone.adapters.RepoAdapter;
import com.example.githubclone.contants.AppConstant;
import com.example.githubclone.models.Repository;
import com.example.githubclone.service.GithubService;
import com.example.githubclone.service.RetrofitClientInstance;
import com.example.githubclone.utils.AppDefaultPreference;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_repos, container, false);

        recyclerView  = root.findViewById(R.id.repos_recyclerView);

        // shared pref
        String username = AppDefaultPreference.getDefaults(AppConstant.USER_PREF_DATA, getActivity());
//        Log.v("USERNAME", username);

        // service
        GithubService githubService = RetrofitClientInstance.getRetrofitInstance().create(GithubService.class);
        Call<List<Repository>> call = githubService.listRepos(username);

        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }

        });


        return root;
    }

    private void generateDataList(List<Repository> repos) {
        RepoAdapter repoAdapter = new RepoAdapter(repos);
        recyclerView.setAdapter(repoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}