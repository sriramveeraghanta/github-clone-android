package com.example.githubclone.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubclone.R;
import com.example.githubclone.adapters.GistAdapter;
import com.example.githubclone.contants.AppConstant;
import com.example.githubclone.models.Gist;
import com.example.githubclone.models.Profile;
import com.example.githubclone.models.Repository;
import com.example.githubclone.service.GithubService;
import com.example.githubclone.service.RetrofitClientInstance;
import com.example.githubclone.utils.AppDefaultPreference;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GistFragment extends Fragment {

    private RecyclerView gistRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gists, container, false);

        // Lookup the recyclerview in activity layout
        gistRecyclerView = root.findViewById(R.id.gists_recyclerView);

        // shared pref
        String username = AppDefaultPreference.getDefaults(AppConstant.USER_PREF_DATA, getActivity());

        // service
        GithubService githubService = RetrofitClientInstance.getRetrofitInstance().create(GithubService.class);
        Call<List<Gist>> call = githubService.listGists(username);

        call.enqueue(new Callback<List<Gist>>() {
            @Override
            public void onResponse(Call<List<Gist>> call, Response<List<Gist>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Gist>> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    private void generateDataList(List<Gist> body) {
        // creating adapter
        GistAdapter adapter = new GistAdapter(body);
        // setting to fragment user adapter
        gistRecyclerView.setAdapter(adapter);
        gistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
