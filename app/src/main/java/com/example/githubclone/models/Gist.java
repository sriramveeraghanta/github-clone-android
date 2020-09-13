package com.example.githubclone.models;

import org.json.JSONObject;

public class Gist {

    private String id;
    private String url;
    private String description;
    private Integer comments;
    private JSONObject files;
    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public JSONObject getFiles() {
        return files;
    }

    public void setFiles(JSONObject files) {
        this.files = files;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
