package com.gp.inmotion.controllers.requests;

public class UserCredentials {

    private String email;
    private String password;

    public UserCredentials(String emails, String password) {
        this.email = emails;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
