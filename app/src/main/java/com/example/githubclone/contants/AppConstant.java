package com.example.githubclone.contants;

public class AppConstant {
    public static final String PROFILE_API = "https://api.github.com/users/";

    public static String USER_PROFILE(String username){
        return  PROFILE_API+ username;
    }
}
