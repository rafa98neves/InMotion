package com.gp.inmotion.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ResetPasswordRequest {

    @NotNull
    @NotEmpty
    private String email;

    public ResetPasswordRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
