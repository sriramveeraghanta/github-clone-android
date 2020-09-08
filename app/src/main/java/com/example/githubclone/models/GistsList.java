package com.example.githubclone.models;

import com.google.gson.JsonArray;

import java.util.List;

public class GistsList {

    private List<UserGistModel> gists;


    public List<UserGistModel> getGists() {
        return gists;
    }

    public void setGists(List<UserGistModel> gists) {
        this.gists = gists;
    }
}
