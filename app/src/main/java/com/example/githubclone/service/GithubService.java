package com.example.githubclone.service;

import com.example.githubclone.models.Gist;
import com.example.githubclone.models.Profile;
import com.example.githubclone.models.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface  GithubService {

    @GET("users/{user}")
    Call<Profile> getUserProfile(@Path("user") String user);

    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);

    @GET("users/{user}/gists")
    Call<List<Gist>> listGists(@Path("user") String user);

    @GET("users/{user}/starred")
    Call<List<Repository>> listStarredRepos(@Path("user") String user);

}
