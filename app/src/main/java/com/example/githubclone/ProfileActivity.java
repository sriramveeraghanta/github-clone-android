package com.example.githubclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.githubclone.contants.AppConstant;
import com.example.githubclone.models.UserProfileModel;
import com.example.githubclone.service.ProfileService;
import com.squareup.picasso.Picasso;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullNameTextView;
    private ImageView profileImageView;
    private TextView bioTextView;
    private TextView usernameTextView;
    private TextView emailTextView;
    private TextView locationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();

        fullNameTextView = findViewById(R.id.profileActivity_fullNameTextView);
        bioTextView = findViewById(R.id.profileActivity_bioTextView);
        usernameTextView = findViewById(R.id.profileActivity_usernameTextView);
        emailTextView = findViewById(R.id.profileActivity_emailTextView);
        locationTextView = findViewById(R.id.profileActivity_locationTextView);

        profileImageView = findViewById(R.id.profileActivity_profileImageView);

        if (intent.hasExtra("username")) {
            try {
                UserProfileModel userProfileModel = new UserProfileModel(
                        new ProfileService().execute("GET", AppConstant.USER_PROFILE(intent.getStringExtra("username"))).get()
                );
                fullNameTextView.setText(userProfileModel.getFullName());
                bioTextView.setText(userProfileModel.getBio());
                usernameTextView.setText(userProfileModel.getUsername());
                emailTextView.setText(userProfileModel.getEmail());
                locationTextView.setText(userProfileModel.getLocation());
                Picasso.get().load(userProfileModel.getAvatarURL())
                        .into(profileImageView);

            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


    }
}