package com.gp.inmotion.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ChangePasswordRequest {

    @NotEmpty
    @NotNull
    private String token;

    @NotEmpty
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    private String password;

    public ChangePasswordRequest(){

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
