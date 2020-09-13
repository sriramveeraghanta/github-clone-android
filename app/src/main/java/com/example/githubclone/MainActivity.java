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
import android.widget.TextView;

import com.example.githubclone.contants.AppConstant;

public class MainActivity extends FragmentActivity {

    private EditText usernameEditText;
    private Button searchButton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(AppConstant.USER_PREF_DATA, "");

        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();


        if(username != null){
//            navigateToHome(username);
        }

        usernameEditText = findViewById(R.id.mainActivity_usernameEditText);
        searchButton = findViewById(R.id.mainActivity_searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToHome(usernameEditText.getText().toString());
            }
        });


    }

    private void navigateToHome(String username) {
        editor = sharedPreferences.edit();
        editor.putString(AppConstant.USER_PREF_DATA, username);
        editor.apply();

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}