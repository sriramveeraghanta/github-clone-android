package com.example.githubclone.contants;

public class AppConstant {
    public static final String PROFILE_API = "https://api.github.com/users/";

    public static final String USER_PREF_DATA = "com.mavenarts.githubclone.user";

    public static String USER_PROFILE(String username){
        return  PROFILE_API+ username;
    }
    public static String USER_GISTS(String username) {return PROFILE_API+username+"/gists";}
}
