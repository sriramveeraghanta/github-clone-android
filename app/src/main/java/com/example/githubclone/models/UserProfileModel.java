package com.example.githubclone.models;

import org.json.JSONException;
import org.json.JSONObject;

public class UserProfileModel {
    private String fullName;
    private String username;
    private String bio;
    private String location;
    private String email;
    private String avatarURL;
    private String reposURL;
    private String organizationsURL;
    private String starredURL;
    private String followersURL;
    private String followingURL;
    private String gistsURL;
    private Boolean hireable;

    public UserProfileModel(JSONObject res) throws JSONException {
        this.setFullName(res.getString("name"));
        this.setUsername(res.getString("login"));
        this.setBio(res.getString("bio"));
        this.setLocation(res.getString("location"));
        this.setEmail(res.getString("email"));
        this.setAvatarURL(res.getString("avatar_url"));
        this.setReposURL(res.getString("repos_url"));
        this.setOrganizationsURL(res.getString("organizations_url"));
        this.setStarredURL(res.getString("starred_url"));
        this.setFollowersURL(res.getString("followers_url"));
        this.setFollowingURL(res.getString("following_url"));
        this.setGistsURL(res.getString("gists_url"));
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getReposURL() {
        return reposURL;
    }

    public void setReposURL(String reposURL) {
        this.reposURL = reposURL;
    }

    public String getOrganizationsURL() {
        return organizationsURL;
    }

    public void setOrganizationsURL(String organizationsURL) {
        this.organizationsURL = organizationsURL;
    }

    public String getStarredURL() {
        return starredURL;
    }

    public void setStarredURL(String starredURL) {
        this.starredURL = starredURL;
    }

    public String getFollowersURL() {
        return followersURL;
    }

    public void setFollowersURL(String followersURL) {
        this.followersURL = followersURL;
    }

    public String getFollowingURL() {
        return followingURL;
    }

    public void setFollowingURL(String followingURL) {
        this.followingURL = followingURL;
    }

    public String getGistsURL() {
        return gistsURL;
    }

    public void setGistsURL(String gistsURL) {
        this.gistsURL = gistsURL;
    }
}
