package com.example.githubclone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.githubclone.contants.AppConstant;
import com.example.githubclone.service.GistsFetchService;
import com.example.githubclone.service.ProfileFetchService;
import com.example.githubclone.ui.main.GistFragment;
import com.example.githubclone.ui.main.ProfileFragment;
import com.example.githubclone.ui.main.RepositoryFragment;
import com.example.githubclone.ui.main.StartedFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.githubclone.adapters.SectionsPagerAdapter;

import java.util.concurrent.ExecutionException;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String searchedUsername = intent.getStringExtra("username");

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        try {
            String response = new ProfileFetchService().execute(searchedUsername).get();

            // saving to the shared pref
            editor.putString(AppConstant.USER_PREF_DATA, response);
            editor.apply();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // tab adapter
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(new RepositoryFragment(), "Repositories");
        sectionsPagerAdapter.addFragment(new GistFragment(), "Gists");
        sectionsPagerAdapter.addFragment(new StartedFragment(), "Started");
        sectionsPagerAdapter.addFragment(new ProfileFragment(), "Profile");

        // page viewer
        ViewPager viewPager = findViewById(R.id.view_pager);
        // tab layout
        TabLayout tabs = findViewById(R.id.tabs);

        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);

    }
}