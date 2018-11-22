package com.example.canto.myfirstapplication;

public class Password {
    private String mDescription;
    private String mUsername;
    private String mPassword;

    public Password(String desc, String mUsername, String pwd) {
        this.mDescription = desc;
        this.mUsername = mUsername;
        this.mPassword = pwd;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        this.mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }
}
