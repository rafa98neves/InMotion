package com.gp.inmotion.payload;

import com.gp.inmotion.security.ApplicationUserRole;

public class WhoAmIResponse {
    private String name;

    private ApplicationUserRole role;

    public WhoAmIResponse(){

    }

    public WhoAmIResponse(String name, ApplicationUserRole role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicationUserRole getRole() {
        return role;
    }

    public void setRole(ApplicationUserRole role) {
        this.role = role;
    }

}
