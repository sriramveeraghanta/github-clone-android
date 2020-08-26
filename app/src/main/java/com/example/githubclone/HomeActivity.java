package com.example.githubclone;

import android.os.Bundle;

import com.example.githubclone.ui.main.OrganisationFragment;
import com.example.githubclone.ui.main.RepositoryFragment;
import com.example.githubclone.ui.main.StartedFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.githubclone.ui.main.SectionsPagerAdapter;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // tab adapter
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(new RepositoryFragment(), "Repositories");
        sectionsPagerAdapter.addFragment(new OrganisationFragment(), "Organisations");
        sectionsPagerAdapter.addFragment(new StartedFragment(), "Started");
        sectionsPagerAdapter.addFragment(new OrganisationFragment(), "Profile");

        // page viewer
        ViewPager viewPager = findViewById(R.id.view_pager);
        // tab layout
        TabLayout tabs = findViewById(R.id.tabs);

        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);

    }
}