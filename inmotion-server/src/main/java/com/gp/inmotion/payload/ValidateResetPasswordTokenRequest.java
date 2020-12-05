package com.gp.inmotion.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ValidateResetPasswordTokenRequest {

    @NotNull
    @NotEmpty
    String token;

    public ValidateResetPasswordTokenRequest() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
