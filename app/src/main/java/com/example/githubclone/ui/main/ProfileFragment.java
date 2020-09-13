package com.example.githubclone.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.githubclone.MainActivity;
import com.example.githubclone.R;
import com.example.githubclone.contants.AppConstant;
import com.example.githubclone.models.Gist;
import com.example.githubclone.models.Profile;
import com.example.githubclone.service.GithubService;
import com.example.githubclone.service.RetrofitClientInstance;
import com.example.githubclone.utils.AppDefaultPreference;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private TextView fullNameTextView;
    private ImageView profileImageView;
    private TextView bioTextView;
    private TextView usernameTextView;
    private TextView emailTextView;
    private TextView locationTextView;
    private TextView hireableTextView;
    private TextView websiteTextView;
    private MaterialIconView locationIconView;
    private MaterialIconView websiteIconView;
    private MaterialIconView emailIconView;
    private MaterialIconView hireableIconView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        // image
        profileImageView = root.findViewById(R.id.profileActivity_profileImageView);
        // header
        fullNameTextView = root.findViewById(R.id.profileActivity_fullNameTextView);
        usernameTextView = root.findViewById(R.id.profileActivity_usernameTextView);
        // bio
        bioTextView = root.findViewById(R.id.profile_bio_textView);
        // location
        locationTextView = root.findViewById(R.id.profile_location_textView);
        websiteTextView = root.findViewById(R.id.profile_website_textView);
        emailTextView = root.findViewById(R.id.profile_email_textView);
        hireableTextView = root.findViewById(R.id.profile_hireable_textView);
        // icons
        locationIconView = root.findViewById(R.id.profile_location_icon);
        websiteIconView = root.findViewById(R.id.profile_website_icon);
        emailIconView = root.findViewById(R.id.profile_email_icon);
        hireableIconView = root.findViewById(R.id.profile_hireable_icon);

        // shared pref
        String username = AppDefaultPreference.getDefaults(AppConstant.USER_PREF_DATA, getActivity());

        // service
        GithubService githubService = RetrofitClientInstance.getRetrofitInstance().create(GithubService.class);
        Call<Profile> call = githubService.getUserProfile(username);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                updateProfileFragment(response.body());
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void updateProfileFragment(Profile userProfile) {
        if(userProfile != null){
            if (userProfile.getName() != null || userProfile.getLogin() != null) {
                fullNameTextView.setText(userProfile.getName());
                usernameTextView.setText(userProfile.getLogin());
            }
            if (userProfile.getBio() != null) {
                bioTextView.setText(userProfile.getBio());
            }

            if (userProfile.getLocation() != null) {
                locationTextView.setText(userProfile.getLocation());
                locationTextView.setVisibility(View.VISIBLE);
                locationIconView.setVisibility(View.VISIBLE);
            }

            if (userProfile.getBlog() != null) {
                websiteTextView.setText(userProfile.getBlog());
                websiteTextView.setVisibility(View.VISIBLE);
                websiteIconView.setVisibility(View.VISIBLE);
            }

            if (userProfile.getEmail() != null) {
                emailTextView.setText(userProfile.getEmail());
                emailTextView.setVisibility(View.VISIBLE);
                emailIconView.setVisibility(View.VISIBLE);
            }

            if (userProfile.getHireable()) {
                hireableTextView.setText("Hired Me.");

            } else {
                hireableTextView.setText("Working.");
            }
            hireableIconView.setVisibility(View.VISIBLE);
            hireableTextView.setVisibility(View.VISIBLE);


            Picasso.get().load(userProfile.getAvatar_url())
                    .into(profileImageView);
        }
    }
}
