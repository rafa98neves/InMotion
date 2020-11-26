package com.gp.inmotion.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public LoginRequest() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
