package com.example.githubclone.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.githubclone.R;

public class ProfileFragment extends Fragment {

    private TextView fullNameTextView;
    private ImageView profileImageView;
    private TextView bioTextView;
    private TextView usernameTextView;
    private TextView emailTextView;
    private TextView locationTextView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        fullNameTextView = root.findViewById(R.id.profileActivity_fullNameTextView);
        bioTextView = root.findViewById(R.id.profileActivity_bioTextView);
        usernameTextView = root.findViewById(R.id.profileActivity_usernameTextView);
        emailTextView = root.findViewById(R.id.profileActivity_emailTextView);
        locationTextView = root.findViewById(R.id.profileActivity_locationTextView);


        return root;
    }
}
