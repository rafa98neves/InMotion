package com.gp.inmotion.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ChangePasswordRequest {

    @NotEmpty
    @NotNull
    private String password;

    @NotEmpty
    @NotNull
    private String token;

    public ChangePasswordRequest(){

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
