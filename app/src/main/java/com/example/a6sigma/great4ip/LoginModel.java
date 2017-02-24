package com.example.a6sigma.great4ip;

/**
 * Created by lenovo on 21/02/2017.
 */

public class LoginModel {
    private String mUsername;
    private String mPassword;
    private int i;

    public LoginModel(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
