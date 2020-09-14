package com.example.githubclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.githubclone.contants.AppConstant;
import com.example.githubclone.utils.AppDefaultPreference;

import static com.example.githubclone.R.drawable.ic_octicons_mark_github;

public class MainActivity extends FragmentActivity {

    private EditText usernameEditText;
    private Button searchButton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ImageView githubImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.mainActivity_usernameEditText);
        searchButton = findViewById(R.id.mainActivity_searchButton);
        githubImageView = findViewById(R.id.github_logo_imageView);

        githubImageView.setImageResource(ic_octicons_mark_github);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        if(AppDefaultPreference.getDefaults(AppConstant.USER_PREF_DATA, MainActivity.this) != null){
            navigateToHome();
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                AppDefaultPreference.setDefaults(AppConstant.USER_PREF_DATA, username, MainActivity.this);
                navigateToHome();
            }
        });


    }

    private void navigateToHome() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}