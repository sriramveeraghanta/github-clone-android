package com.example.githubclone.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubclone.R;
import com.example.githubclone.adapters.GistAdapter;
import com.example.githubclone.contants.AppConstant;
import com.example.githubclone.models.GistsList;
import com.example.githubclone.models.UserGistModel;
import com.example.githubclone.models.UserProfileModel;
import com.example.githubclone.service.GistsFetchService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GistFragment extends Fragment {

    private List<UserGistModel> gistsList;
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

        // Initializing gson;
        Gson gson = new Gson();

        // type
        Type type = new TypeToken<List<UserGistModel>>(){}.getType();


        // fetching user profile saved in the user shared pref....
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(AppConstant.USER_PREF_DATA, "");
        // converting to user model
        UserProfileModel userProfile = gson.fromJson(json, UserProfileModel.class);

        Log.v("USERNAME", ""+userProfile.getLogin());
        try {
            // fetching user Gists List from Api.
            String response = new GistsFetchService().execute(userProfile.getLogin()).get();
            Log.v("RESPONSE", response);
            // Converting user info
            gistsList =  gson.fromJson(response, type);
            Log.v("SIZE", ""+gistsList.size());

            // creating adapter
            GistAdapter adapter = new GistAdapter(gistsList);
            // setting to fragment user adapter
            gistRecyclerView.setAdapter(adapter);
            gistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return root;
    }
}
