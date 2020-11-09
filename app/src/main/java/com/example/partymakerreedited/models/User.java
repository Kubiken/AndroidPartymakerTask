package com.example.partymakerreedited.models;

public class User {

    private String avatarUrl;
    private String name;
    private String id;

    public User() {
        avatarUrl="";
        id="";
        name="Anonymous";
    }

    public User(String avatarUrl, String name, String id) {
        this.avatarUrl = avatarUrl;
        this.id = id;
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
